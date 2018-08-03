NRX_COMPILE_COMMAND = java -cp $(CLASSPATH):/Users/rvjansen/Sites/netrexx/WEB-INF/classes -Dnrx.compiler=ecj org.netrexx.process.NetRexxC 
NRX_COMPILE_FLAGS = -comments -sourcedir -time -keepasjava -replace -warnexit0 -compact -nocrossref -utf8

JAVA_COMPILE_COMMAND = java org.eclipse.jdt.internal.compiler.batch.Main 
JAVA_COMPILE_FLAGS = -warn:-unusedPrivate -warn:-unusedLocal -Xemacs

.nrx.class:
	$(NRX_COMPILE_COMMAND) $< $(NRX_COMPILE_FLAGS)
#	$(JAVA_COMPILE_COMMAND) $(JAVA_COMPILE_FLAGS) $*.java

NRX_SRC		:= $(wildcard *.nrx)
NRX_OBJS	:= $(NRX_SRC:.nrx=.class)
JAVA_SRC	:= $(wildcard *.java)
JAVA_OBJS	:= $(JAVA_SRC:.java=.class)
TARGET		:= thebook
PDFTARGET	:= $(TARGET).pdf
TEX_SRC		:= $(wildcard *.tex)
LATEX_EXE	:= pdflatex -file-line-error


.SUFFIXES: .nrx .nry .njp .class .skel .xsl .java .pdf

#
# target all compiles the netrexx and java code
#
all::	OutputLineEvent.class OutputEventListener.class $(NRX_OBJS) $(JAVA_OBJS)

fromscratch::
	$(NRX_COMPILE_COMMAND) *.nrx $(NRX_COMPILE_FLAGS)
#	$(JAVA_COMPILE_COMMAND) $(JAVA_COMPILE_FLAGS) *.java

#
# target clean removes compiled products
#
.PHONY: clean
clean: 
	rm -f *.class
	rm -f *.crossref
	rm -f *.bak
	rm -f *~
	rm -f input/*~
	find . -name "*.nrx" | awk '{$$2 = $$1 ; sub ( /\.nrx/,".java",$$1 ) ; print $$1 }' | xargs rm -f


$(TARGET).pdf: $(TEX_SRC)
	$(MAKE) -k $(TARGET).bbl
	$(LATEX_EXE) $(TARGET).tex
	@while ( grep "There were undefined references." $(TARGET).log >/dev/null ); do \
		echo '** Re-running pdfLaTeX **'; \
		$(LATEX_EXE) $(TARGET).tex; \
		makeindex $(TARGET); \
	done

$(TARGET).bbl: $(TEXSRC) $(BIBSRC)
	$(LATEX_EXE) $(TARGET).tex
#	bibtex $(TARGET)
	makeindex $(TARGET)

