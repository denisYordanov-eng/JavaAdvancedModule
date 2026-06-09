package panzer.io;

import panzer.contracts.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader implements InputReader {
    BufferedReader br;

    public Reader() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }
    @Override
    public String readLine() throws IOException {
        return this.br.readLine();
    }
}
