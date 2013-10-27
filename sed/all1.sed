#!/bin/sed -nf
#druknij linie niezawierajace "cannot":
sed -ne '/cannot/!{p; q}' file
#zagniezdzanie - druknij druga linie po lini z MISSING ale tylko jesli nie ma ".jsp":

