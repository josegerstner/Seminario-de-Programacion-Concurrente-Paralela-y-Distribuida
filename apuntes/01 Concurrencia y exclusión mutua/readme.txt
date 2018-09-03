This archive contains slides for the book:

M. Ben-Ari. 
Principles of Concurrent and Distributed Programming (Second Edition).
Addison-Wesley/Pearson, 2006.

The slides were extracted directly from the LaTeX source of the book and
formatted with powerdot. (The previous version the slides used seminar.)
The LaTeX source as well as formatted PDF is included. The slides were
formatted using MiKTeX version 2.9 on Windows. THe commands used are:

  latex  slides
  dvips  slides
  ps2pdf slides.ps

There are a few places where algorithms have been slightly edited to
enable them to be put on one slide or divided logically between slides.
The programs have also been edited for reasonable breaks between slides;
therefore, the line numbers no longer correspond with the numbers in the
book.

Three of style files are included in this archive:
-- slides.sty contains the commands and environments for the slides
-- pics.sty contains commands for drawing diagrams
-- lstlang0.sty contains language definitions for the listings package
   (This is needed only for the SPARK code)
