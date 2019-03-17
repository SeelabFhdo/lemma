#!/usr/bin/env python3

import os
import re
import sys

LINECOUNT_INFO_REGEX = re.compile("java;(?P<manual>\d+);(?P<generated>\d+);" \
    "(?P<diff>\d+);(?P<ratio>\d+(\.\d+)?)")

def summarize_line_counts(startFolder):
    componentFolders = sorted(get_component_folders(startFolder))
    fileLineCountInfoOverall = {}
    for folder in componentFolders:
        lineCountInfo = do_line_count_summary(folder)
        for file, fileLineCountInfo in lineCountInfo.items():
            fileBasename = basename(file)
            if fileBasename not in fileLineCountInfoOverall:
                fileLineCountInfoOverall[fileBasename] = fileLineCountInfo
            else:
                fileLineCountInfoOverall[fileBasename] += fileLineCountInfo

    print('{0:<58}{1:<15}{2:<15}{3:<15}{4:<15}'.format(
        'Overall',
        'Manual',
        'Generated', 
        'Diff',
        'Ratio')
    )
    for fileBasename, lineCountInfo in fileLineCountInfoOverall.items():
        lineCountInfo.ratio = float("{0:.2f}".format(
            lineCountInfo.diff / lineCountInfo.generated * 100
        ))
        print('\t{0:<50}{1:<15}'.format(fileBasename, lineCountInfo))

def get_component_folders(parentFolder):
    return [os.path.join(parentFolder, subElement)
        for subElement in os.listdir(parentFolder)
        if os.path.isdir(os.path.join(parentFolder, subElement))]

def do_line_count_summary(folder):
    lineCountFiles = get_csv_files(folder)
    collectedLineCountInfo = {}
    for file in lineCountFiles:
        lineCountInfo = find_line_count_info(file)
        if lineCountInfo is not None:
            collectedLineCountInfo[file] = lineCountInfo

    component = basename(os.path.normpath(folder))
    print('{0:<58}{1:<15}{2:<15}{3:<15}{4:<15}'.format(
        component,
        'Manual',
        'Generated', 
        'Diff',
        'Ratio')
    )
    for file, lineCountInfo in collectedLineCountInfo.items():        
        print('\t{0:<50}{1:<15}'.format(basename(file), lineCountInfo))
    print()

    return collectedLineCountInfo
            

def basename(path):
    return os.path.basename(os.path.normpath(path))

def find_line_count_info(file):
    fobj = open(file, 'r')
    for line in fobj:
        lineCountInfo = re.match(LINECOUNT_INFO_REGEX, line.strip())
        if lineCountInfo is not None:
            fobj.close()            
            return LineCountInfo.fromregex(lineCountInfo)
            
    fobj.close()
    return None

class LineCountInfo:    
    def __init__(self, manual, generated, diff, ratio):
        self.manual = int(manual)
        self.generated = int(generated)
        self.diff = int(diff)
        self.ratio = float(ratio)

    @classmethod
    def fromregex(self, lineCountInfo):
        return LineCountInfo(
            lineCountInfo.group('manual'),
            lineCountInfo.group('generated'),
            lineCountInfo.group('diff'),
            lineCountInfo.group('ratio')
        )

    def __format__(self, format_spec):
        return '{0:<15}{1:<15}{2:<15}{3:<15}'.format(
            str(self.manual),
            str(self.generated),
            str(self.diff),
            str(self.ratio)
        )

    def __add__(self, other):
        return LineCountInfo(
            self.manual + other.manual,
            self.generated + other.generated,
            self.diff + other.diff,
            0
        )

def get_csv_files(parentFolder):
    return [os.path.join(parentFolder, subElement)
        for subElement in os.listdir(parentFolder)
        if os.path.isfile(os.path.join(parentFolder, subElement)) \
            and subElement.endswith('.csv')]

if __name__ == '__main__':
    if len(sys.argv) < 2:
        print('You need to pass at least one argument')
        sys.exit(4)

    startFolder = sys.argv[1]
    if not os.path.isdir(startFolder):
        print('The passed argument "%s" does not represent a folder' \
            % startFolder)

    summarize_line_counts(startFolder)
