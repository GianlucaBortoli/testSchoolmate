#!/bin/bash
echo "Copying new sources..."
scp -r fixedSchoolmate/* sectesting:/var/www/html &> /dev/null
echo "Done!"
echo "Restarting webserver..."
ssh root@sectesting "service apache2 restart" &> /dev/null
echo "Done!"
