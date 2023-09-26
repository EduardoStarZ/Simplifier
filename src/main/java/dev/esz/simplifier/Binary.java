package dev.esz.simplifier;

public class Binary extends Mathematical {

        private boolean[] binary = new boolean[0];
        private int number = 0;
        private int closest = 0;

        public Binary(int value) {
            number = value;

            while (true) {
                int compare = 2;

                if (compare < value) {
                    compare *= 2;
                } else {
                    closest = compare;
                    break;
                }
            }

            calculateAmountOfDigits();
            defineDigits();
        }

        private void calculateAmountOfDigits() {
            for(int i= 1; i<number; i *= 2) {
                binary = new boolean[binary.length];

                closest /= 2;

                if (closest == 0) {
                    break;
                }
            }
        }

        private int translateToNumber() {
            int power = 2;
            int number = 0;

            for (int i = 0; i <= binary.length - 1; i++) {
                if (i == 0) {
                    if (binary[i]) {
                        number++;
                    }
                }

                if (binary[i]) {
                    number += power;
                }

                power *= 2;
            }

            return number;
        }

        private void defineDigits() {
            for (int i = binary.length - 1; i >= 0; i--) {
                binary[i] = true;

                if (translateToNumber() > number) {
                    binary[i] = false;
                }
                if (translateToNumber() == number) {
                    return;
                }
            }
        }

        public void print() {
            for(int i=0; i<=binary.length-1; i++) {
                System.out.println(binary[i] + ", ");
            }
        }
    }