#!/bin/sed -nf
#druknij linie niezawierajace "cannot":
sed -ne '/cannot/!{p; q}' file
#zagniezdzanie - druknij druga linie po lini z MISSING ale tylko jesli nie ma ".jsp":
TBD TODO
---
wykrywanie branchy cvs
#!/bin/sed -nf
/^File:/{
    s/File: \(\w*\.java\).*/\1/
    h
    n
    n
    #s/Working revision\W.*\(1\.[0-9]\+\.[0-9]\+\)[^\.0-9]\+.*/\1/p
    /Working revision\W.*\(1\.[0-9]\+\.[0-9]\+\.[0-9]\+\).*/{
        s/Working revision\W.*\(1\.[0-9]\+\.[0-9]\+\.[0-9]\+\).*/\1/
        H
        x
        p
    }
}

cvs stat 2>&1 | /home/mmartys/moje/bash/branchSed.sh
---
