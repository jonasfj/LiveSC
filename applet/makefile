SOURCES	= $(shell find jtlv/ -name "*.java")
LIBS	= libs/javabdd-2.0.jar:libs/antlr-runtime-3.0.1.jar:libs/jdd.jar
Applet.jar: jtlv.jar Applet.java
	rm -f Applet.jar
	rm -rf bin/Applet/
	mkdir -p bin/Applet/
	javac Applet.java LSCGame.java -d bin/Applet/ -classpath jtlv.jar:$(LIBS)
	cd bin/Applet/; find | xargs jar -cf Applet.jar; cd -
	cp bin/Applet/Applet.jar Applet.jar
LSCSMVChecker.jar: jtlv.jar LSCSMVChecker.java
	rm -f LSCSMVChecker.jar
	rm -rf bin/LSCSMVChecker/
	mkdir -p bin/LSCSMVChecker/
	javac LSCSMVChecker.java LSCGame.java -d bin/LSCSMVChecker/ -classpath jtlv.jar:$(LIBS)
	cd bin/LSCSMVChecker/; find | xargs jar -cfe LSCSMVChecker.jar LSCSMVChecker; cd -
	cp bin/LSCSMVChecker/LSCSMVChecker.jar LSCSMVChecker.jar
jtlv.jar:
	mkdir -p bin/jtlv/
	javac -classpath $(LIBS) -d bin/jtlv/ $(SOURCES)
	cd bin/jtlv/; find | xargs jar -cf jtlv.jar; cd -
	cp bin/jtlv/jtlv.jar jtlv.jar
clean:
	rm -rf bin/
	rm -f jtlv.jar
	rm -f Applet.jar
	rm -f LSCSMVChecker.jar
	rm TS.smv
ifdef lsc
test: LSCSMVChecker.jar
	@clear
	@echo "-------------------------------------------------------------------------------------------------"
	coffee makeSMV.coffee ../examples/$(lsc).lsc
	@java -cp LSCSMVChecker.jar:jtlv.jar:$(LIBS) LSCSMVChecker --check TS.smv
else
test:
	@echo "LSCs available for test:"
	@ls ../examples/*.lsc | sed -e "s/\.\.\/examples\/\(.*\)\.lsc/\1/g"
endif
pack: Applet.jar LSCSMVChecker.jar
	tar -czf LSCSMVChecker.tar.gz LSCSMVChecker LSCSMVChecker.jar jtlv.jar libs/javabdd-2.0.jar libs/antlr-runtime-3.0.1.jar libs/jdd.jar
	tar -czf Applet.tar.gz Applet.jar jtlv.jar libs/javabdd-2.0.jar libs/antlr-runtime-3.0.1.jar libs/jdd.jar
