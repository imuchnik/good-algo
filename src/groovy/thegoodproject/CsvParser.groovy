package thegoodproject

// FIXME line breaks in field values are probably not supported
public class CsvParser {
    private static final String REGEX = /,(?=([^\"]*\"[^\"]*\")*[^\"]*$)/

    Object parseText(String text, boolean hasHeader) {
        if (!text) {
            throw new IllegalArgumentException('CSV text may not be null or empty')
        }

        parse(new StringReader(text), hasHeader)
    }

    /**
     * Parses the contents of the reader into a CSV data structure.
     * The {@code hasHeader} attribute signals if the CSV text starts with a header describing the field names.
     * This cannot be determined on the fly when reading CSV.
     * <p>
     * If no headers are present, the resulting will records will expose their properties with {@fieldX}
     * properties, where X is a number starting from 0.
     *
     * @param reader the reader containing the CSV contents
     * @param hasHeader signal to interpret the first line as a CSV header
     */
    Object parse(Reader reader, boolean hasHeader) {
        List<String> headers = []

        if (hasHeader) {
            String line = null

            // read until a line is found
            while (!line) {
                line = reader.readLine()
            }

            line.split(REGEX).each {String header ->
                headers << header.replaceAll(/"/, '').trim()
            }
        }

        parse(reader, headers)
    }


    /**
     * Parses the CSV content of the specified reader into a data structure.
     * The field names are specified by the headers parameter.
     */
    Object parse(Reader reader, List<String> headers) {
        List result = []

        reader.readLines().each {String line ->
            // skip empty lines
            if (line) {
                result << parseRecord(headers, line)
            }
        }

        // in case we have 1 result, return the result itself
        result.size() == 1 ? result[0] : result
    }

    private Object parseRecord(List<String> fieldNames, String line) {
        Map<String, ?> record = [:]

        line.split(REGEX).eachWithIndex {String fieldValue, int index ->
            String fieldName = (fieldNames) ? fieldNames[index] : "field${index}"

            record[fieldName] = fieldValue.replaceAll(/"/, '').trim()
        }

        record
    }
}