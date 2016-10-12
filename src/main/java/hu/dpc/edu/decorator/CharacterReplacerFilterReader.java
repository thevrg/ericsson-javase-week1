package hu.dpc.edu.decorator;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by vrg on 12/10/16.
 */
public class CharacterReplacerFilterReader extends FilterReader {

    private char whatToReplace;
    private char replaceToWhat;

    public CharacterReplacerFilterReader(Reader in, char whatToReplace, char replaceToWhat) {
        super(in);
        this.whatToReplace = whatToReplace;
        this.replaceToWhat = replaceToWhat;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        final int charactersRead = super.read(cbuf, off, len);
        for(int i = off; i < off + len; i++) {
            int actualChar = cbuf[i];
            if (actualChar == whatToReplace) {
                cbuf[i] = replaceToWhat;
            }
        }
        return charactersRead;
    }
}
