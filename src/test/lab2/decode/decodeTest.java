package test.lab2.decode;

import main.lab2.decode.Decode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class decodeTest {
    Decode decode = new Decode();
    @Test
    void decodesHtlm() {
        String input = "Cat &lt;says&gt; &quot;Meow&quot;. M&amp;M&apos;s";
        String rightOut = "Cat <says> 'Meow'. M&M's";
        String out = decode.HtmlDecode(input);
        assertEquals(rightOut, out);
    }

    @Test
    void decodesTextWithoutHtml() {
        String input = "String with letters only";
        String rightOut = "String with letters only";
        String out = decode.HtmlDecode(input);
        assertEquals(rightOut, out);
    }

    @Test
    public void decodesForOnlySymbols() {
        String input ="&quot;&apos;&lt;&gt;&amp;&lt;&gt;&apos;&quot;";
        String rightOut = "''<>&<>''";
        String out = decode.HtmlDecode(input);
        assertEquals(rightOut, out);
    }
}