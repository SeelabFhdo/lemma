package de.fhdo.lemma.data

import java.util.Date
import java.time.format.DateTimeFormatter
import java.time.LocalDate
import java.time.LocalTime
import java.time.LocalDateTime
import java.time.format.DateTimeParseException
import java.time.ZoneId

/**
 * Utility methods for dealing with date strings and formats supported by LEMMA.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class DateUtils { 
    /**
     * Parse a date string in the date formats supported by LEMMA
     */
     static def Date parseDate(String dateString) {
        val format = determineDateFormat(dateString)

        return switch(format) {
            case DateTimeFormatter.ISO_LOCAL_DATE,
            case DateTimeFormatter.ISO_OFFSET_DATE,
            case DateTimeFormatter.ISO_DATE:
                Date.from(LocalDate.parse(dateString, format)
                    .atStartOfDay(ZoneId.systemDefault()).toInstant())

            case DateTimeFormatter.ISO_LOCAL_TIME,
            case DateTimeFormatter.ISO_OFFSET_TIME,
            case DateTimeFormatter.ISO_TIME:
                Date.from(LocalDate.parse(dateString, format)
                    .atStartOfDay(ZoneId.systemDefault()).toInstant())

            case DateTimeFormatter.ISO_LOCAL_DATE_TIME,
            case DateTimeFormatter.ISO_OFFSET_DATE_TIME,
            case DateTimeFormatter.ISO_DATE_TIME:
                Date.from(LocalDate.parse(dateString, format)
                    .atStartOfDay(ZoneId.systemDefault()).toInstant())

            default: null
        }
     }

    /**
     * Determine the date format of a date string from all of LEMMA's supported date formats
     */
     static def determineDateFormat(String dateString) {
        val supportedDateFormats = newArrayList(
            DateTimeFormatter.ISO_LOCAL_DATE,
            DateTimeFormatter.ISO_OFFSET_DATE,
            DateTimeFormatter.ISO_DATE,
            DateTimeFormatter.ISO_LOCAL_TIME,
            DateTimeFormatter.ISO_OFFSET_TIME,
            DateTimeFormatter.ISO_TIME,
            DateTimeFormatter.ISO_LOCAL_DATE_TIME,
            DateTimeFormatter.ISO_OFFSET_DATE_TIME,
            DateTimeFormatter.ISO_DATE_TIME
        )

        return supportedDateFormats.findFirst[ isDateOfFormat(dateString, it) ]
     }

     /**
      * Check if a date string is of a given date format
      */
     static def isDateOfFormat(String dateString, DateTimeFormatter format) {
         return try {
            switch(format) {
                case DateTimeFormatter.ISO_LOCAL_DATE,
                case DateTimeFormatter.ISO_OFFSET_DATE,
                case DateTimeFormatter.ISO_DATE: {
                    LocalDate.parse(dateString, format)
                    true
                }

                case DateTimeFormatter.ISO_LOCAL_TIME,
                case DateTimeFormatter.ISO_OFFSET_TIME,
                case DateTimeFormatter.ISO_TIME: {
                    LocalTime.parse(dateString, format)
                    true
                }

                case DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                case DateTimeFormatter.ISO_OFFSET_DATE_TIME,
                case DateTimeFormatter.ISO_DATE_TIME: {
                    LocalDateTime.parse(dateString, format)
                    true
                }

                default: false
            }
        } catch (DateTimeParseException ex) {
            false
        }
     }
}