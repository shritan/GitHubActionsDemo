/**
 *
 */
package com.test.example;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

/**
 * @author Mohan Rao
 *
 */
public class CertsGenerateApp {
    public static void main(final String[] args) throws IOException {
        /*
         * final String filePath = "C:\\opt\\app\\dotc\\ccscert\\S1014988_64encoded.txt"; final
         * String content = new String(Files.readAllBytes(Paths.get(filePath)));
         */
        /*
         * final String stageContent =
         * "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";
         * byte[] decodedBytes = Base64.getDecoder().decode(stageContent); File file = new
         * File("c:\\opt\\S1014988.pfx"); writeCerts(file, decodedBytes); final String prodContent =
         * "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";
         * decodedBytes = Base64.getDecoder().decode(prodContent); file = new
         * File("c:\\opt\\Z1168049.pfx");
         *
         * // generate Test env cert file writeCerts(file, decodedBytes);
         */

        final String testContent =
            "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";
        final byte[] testDecodedBytes = Base64.getDecoder().decode(testContent);
        final File file = new File("C:\\opt\\app\\dotc\\ccscert\\S1014988.pfx");
        writeCerts(file, testDecodedBytes);
    }

    private static void writeCerts(final File file, final byte[] decodedBytes) {
        try (OutputStream os = Files.newOutputStream(Path.of(file.getPath()))) {
            os.write(decodedBytes);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}