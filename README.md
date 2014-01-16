This is a simple word finder for Mnemonic Major System for Slovenian.

See http://en.wikipedia.org/wiki/Mnemonic_major_system .

Word list obtained from http://bos.zrc-sazu.si/besede.html .

Usage:
`Mapping.getWordsForNumber(8190)` will return the list of words that are mnemonics for `8190`:

    avtobaza
    avtobias
    avtobus
    avtoopis
    avtopoeza
    avtopoieza
    avtopsiha
    avtopsija
    fidibus
    fotopis
    fotopoezija
    svatbica
    svetopis
    videoopus
    vodopis
    vodopisje

Run `mvn test` to build the project and execute some example test code; results will be written to the console.

This can be easily adapted for other languages: just replace the contents of `words.txt` with words from the language,
and slightly tweak the `charMap` entries in `Mapping.java`.

The character-to-number mapping used here for Slovenian is:

        c, s, z --> 0
        t, d    --> 1
        n       --> 2
        m       --> 3
        r       --> 4
        l       --> 5
        č, š, ž --> 6
        k, g, q --> 7
        f, v    --> 8
        p, b    --> 9
