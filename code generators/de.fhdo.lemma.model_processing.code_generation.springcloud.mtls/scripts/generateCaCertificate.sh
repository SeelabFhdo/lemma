#!/bin/bash


input="./test.txt"

while IFS= read -r line
do
   ## take some action on $line
  echo "$line"
  eval $line
done < "$input"

echo "Password $PASS"
echo "Domain $DOMAIN"
echo "KeyPath $KEYPATH"
echo "Filename $FILENAME"
echo "Bitrate $BITRATE"

if [ -z "$BITRATE"]; then
  echo "Set bitrate to 4096"
  BITRATE=4096
fi

if [ -z "$BITRATE"]; then
  echo "Set bitrate to 4096"
  BITRATE=4096
fi


#Generating a private key for the certificate authority
openssl genrsa -aes256 -passout pass:$PASS -out $KEYPATH/ca/ca_key.pem $BITRATE
#Generating a public key for the certificate authority
openssl req -new -passin pass:$PASS -key $KEYPATH/ca/ca_key.pem -x509 -days 365 -out $KEYPATH/ca/ca_cert.pem -subj "/CN=ca.$DOMAIN"

