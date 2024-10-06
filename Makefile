.PHONY: build
build:
	find src -name ".antlr" -exec rm -r {} \; &&\
	find src -name '*.java' | xargs javac -d bin -cp /usr/local/bin/antlr-4.13.2-complete.jar
.PHONY: run
run: 
	cd bin && java -cp /usr/local/bin/antlr-4.13.2-complete.jar:. Main

.PHONY: genantlr
genantlr:
	java -jar /usr/local/bin/antlr-4.13.2-complete.jar -visitor ./src/Grammar/Mx.g4