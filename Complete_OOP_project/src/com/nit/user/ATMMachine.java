package com.nit.user;

import java.util.Scanner;
import java.util.InputMismatchException;

import com.nit.blogic.ATMCard;
import com.nit.exception.InsufficientFundsException;
import com.nit.exception.InvalidAmountException;

public class ATMMachine {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("\nInsert card (provide fully qualified class name): ");
                String cardName = scn.nextLine();

                // Loading and instantiating the given card class
                Class<?> cls = Class.forName(cardName);
                Object obj = cls.getDeclaredConstructor().newInstance();

                if (obj instanceof ATMCard card) { // Java 14 pattern matching

                    loop: while (true) {
                        System.out.println("\nChoose one option:");
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Balance Inquiry");
                        System.out.println("4. Mini Statement");
                        System.out.println("5. Exit");

                        System.out.print("Enter option number: ");
                        String option = scn.nextLine();

                        switch (option) {
                            case "1": {
                                while (true) {
                                    try {
                                        System.out.print("\nEnter Deposit Amount: ");
                                        double amt = scn.nextDouble();
                                        scn.nextLine();

                                        card.deposit(amt);
                                        System.out.println(amt + " cash credited to your Account");
                                        card.currentBalance();
                                        break;
                                    } catch (InvalidAmountException e) {
                                        System.out.println("<ERROR>: " + e.getMessage());
                                    } catch (InputMismatchException e) {
                                        System.out.println("<Error>: Enter only numeric value");
                                        scn.nextLine();
                                    }
                                }
                                break;
                            }

                            case "2": {
                                while (true) {
                                    try {
                                        System.out.print("\nEnter Amount to withdraw: ");
                                        double amt = scn.nextDouble();
                                        scn.nextLine();

                                        card.withdraw(amt);
                                        System.out.println("Take your cash.");
                                        System.out.println(amt + " cash debited from your account");
                                        card.currentBalance();
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("<Error>: Enter only numeric value");
                                        scn.nextLine();
                                    } catch (InvalidAmountException | InsufficientFundsException e) {
                                        System.out.println("<ERROR>: " + e.getMessage());
                                    }
                                }
                                break;
                            }

                            case "3": {
                                card.currentBalance();
                                break;
                            }

                            case "4": {
                                System.out.println("Mini Statement service is temporarily out of service.");
                                break;
                            }

                            case "5": {
                                System.out.println("\nTAKE YOUR CARD");
                                System.out.println("*********** Thank You. Visit Again. ***********");
                                break loop;
                            }

                            default: {
                                System.out.println("Invalid option. Please try again.");
                            }
                        }
                    }

                } else {
                    System.out.println("The class does not implement ATMCard interface.");
                }

            } catch (ClassNotFoundException e) {
                System.out.println("<ERROR>: Could not find .class file: " + e.getMessage());
            } catch (InstantiationException e) {
                System.out.println("<ERROR>: No-arg constructor is not available.");
            } catch (IllegalAccessException e) {
                System.out.println("<ERROR>: No-arg constructor is not public.");
            } catch (Exception e) {
                System.out.println("<ERROR>: Unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
