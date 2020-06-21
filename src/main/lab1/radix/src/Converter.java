package main.lab1.radix.src;

import java.util.ArrayList;
import java.util.List;

class Converter {
    private static final int MIN_NOTATION = 2;
    private static final int MAX_NOTATION = 36;
    private static final String VALID_SYMBOLS = "0123456789ABCDEFGHIJKLMNOPQRASUVWXYZ";
    private final List<Integer> number = new ArrayList<>();
    private final int radix;
    private boolean isValueNegative = false;

    Converter(final String number, final int radix) {
        this.radix = radix;
        for (int i = 0; i < number.length(); i++) {
            char ch = number.toUpperCase().charAt(i);
            if (ch == '-') {
                isValueNegative = true;
            }
            if (VALID_SYMBOLS.indexOf(ch) == -1) {
                continue;
            }
            this.number.add(Converter.charToInt(ch, radix));
        }
    }

    static boolean isRadixValid(final int radix) {
        return radix >= MIN_NOTATION && radix <= MAX_NOTATION;
    }

    static boolean isValueValid(final String value, final int radix) {
        for (int i = 0; i < value.length(); i++) {
            final int ch = charToInt(value.charAt(i), radix);
                if (ch > radix - 1) {
                    return false;
                }
        }
        return true;
    }

    private static int charToInt(final char character, final int radix) {
        final boolean isMoreEqThenZero = character >= '0';
        final boolean isLessEqThenNine = character <= '9';
        final boolean isLessThenRadix = (character - '0') < radix;
        if (isMoreEqThenZero && isLessEqThenNine && isLessThenRadix) {
            return character - '0';
        } else {
            final boolean isMoreEqThenA = character >= 'A';
            final boolean isMoreThenZ = character > 'Z';
            final boolean isLessThenA = character < 'A';
            if (isMoreThenZ || isLessThenA) {
                return 1024;
            }
            final boolean isLessEqThenZ = character <= 'Z';
            final boolean isALessThenRadix = (character - 'A') < radix;
            if (isMoreEqThenA && isLessEqThenZ && isALessThenRadix) {
                return character - 'A' + 10;
            } else {
                return -1;
            }
        }
    }

    private static char intToChar(final int character) {
        final boolean isMoreThenZero = character >= 0;
        final boolean isLessThenNine = character <= 9;
        if (isMoreThenZero && isLessThenNine) {
            return (char) (character + '0');
        } else {
            return (char) (character + 'A' - 10);
        }
    }

    private int getNextNumber(final int nextRadix) {
        int temp = 0;
        for (int i = 0; i < number.size(); i++) {
            temp = temp * radix + number.get(i);
            number.set(i, temp / nextRadix);
            temp = temp % nextRadix;
        }
        return temp;
    }

    private boolean hasOnlyZeroes() {
        for (int integer : number) {
            if (integer != 0) {
                return false;
            }
        }
        return true;
    }

    String convert(final int nextRadix) {
        final List<Integer> buffer = new ArrayList<>();
        do {
            buffer.add(getNextNumber(nextRadix));
        } while (!hasOnlyZeroes());
        final var temp = new StringBuilder();
        for (int i = buffer.size() - 1; i >= 0; i--) {
            temp.append(intToChar(buffer.get(i)));
        }
        if (isValueNegative) {
            temp.insert(0, '-');
        }
        return temp.toString();
    }
}