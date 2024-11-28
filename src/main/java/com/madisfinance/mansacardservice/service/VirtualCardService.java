package com.madisfinance.mansacardservice.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.madisfinance.mansacardservice.dto.VirtualCard;
import com.madisfinance.mansacardservice.repository.VirtualCardRepository;

@Service
public class VirtualCardService {
    private final VirtualCardRepository cardRepository;

    public VirtualCardService(VirtualCardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public VirtualCard createVirtualCard() {
        String cardNumber = CardNumberGenerator.generateRandomCardNumber();
        String expirationDate = CardNumberGenerator.generateExpirationDate();
        String cvv = CardNumberGenerator.generateCvv();
        // Create and return the virtual card
        return this.cardRepository.save(new VirtualCard(Long.MAX_VALUE, cardNumber, expirationDate, cvv));
    }

    static class CardNumberGenerator {
        private static final Random random = new Random();

        private CardNumberGenerator() {
            // nothing to do
        }

        public static String generateExpirationDate() {
            // Implement expiration date generation logic
            return LocalDate.now().plusYears(2).minusMonths(1).format(DateTimeFormatter.ofPattern("MM/yy"));
        }

        public static String generateCvv() {
            // Implement CVV generation logic
            StringBuilder cvv = new StringBuilder();
            // Add random digits for the 3 digits
            for (int i = 1; i <= 3; i++) {
                int digit = random.nextInt(10); // Generate a random digit (0-9)
                cvv.append(digit);
            }
            return cvv.toString();
        }

        // Method to generate a random card number
        public static String generateRandomCardNumber() {
            StringBuilder cardNumber = new StringBuilder();

            // Add the Issuer Identification Number (IIN)
            cardNumber.append("4"); // Visa starts with 4

            // Add random digits for the remaining 15 digits (excluding the IIN)
            for (int i = 1; i <= 15; i++) {
                int digit = random.nextInt(10); // Generate a random digit (0-9)
                cardNumber.append(digit);
            }

            // Add the final digit (Check Digit) using Luhn algorithm
            int checkDigit = calculateLuhnCheckDigit(cardNumber.toString());
            cardNumber.append(checkDigit);

            return cardNumber.toString();
        }

        // Method to calculate the Check Digit using the Luhn algorithm
        private static int calculateLuhnCheckDigit(String cardNumber) {
            int sum = 0;
            boolean doubleDigit = false;

            // Iterate through the card number digits in reverse order
            for (int i = cardNumber.length() - 1; i >= 0; i--) {
                int digit = Character.getNumericValue(cardNumber.charAt(i));

                // Double every second digit
                if (doubleDigit) {
                    digit *= 2;
                    if (digit > 9) {
                        digit -= 9;
                    }
                }

                // Add the digit to the sum
                sum += digit;

                // Toggle the doubleDigit flag for the next iteration
                doubleDigit = !doubleDigit;
            }

            // Calculate the Check Digit as the difference between the sum and the next
            // multiple of 10
            return (10 - (sum % 10)) % 10;
        }

        public static String formatCard(String cardNumber) {
            if (cardNumber == null)
                return null;
            char delimiter = ' ';
            return cardNumber.replaceAll(".{4}(?!$)", "$0" + delimiter);
        }
    }

}
