package com.go2it.Lesson4;

public class ATMService {
    public static void installNewVersion(Software newSoftware, ATM atm) throws InterruptedException, SoftwareUpdateException {
        System.out.println("Number of version is " + atm.getCurrentSoftwareVersion());
        if (atm.getCurrentSoftwareVersion() > newSoftware.getVersion()) {
            throw new SoftwareUpdateException("This version of software is too old");
        }

        ATM.setPreviousSoftwareVersion(atm.getCurrentSoftwareVersion());
        System.out.println("The update process has started... Wait please");
        Thread.sleep(4000);

        System.out.println("Number of new version is " + atm.setCurrentSoftwareVersion(newSoftware.getVersion())
                + " which was released " + newSoftware.getDate());
    }

    public static void recoverSoftware(ATM atm) throws InterruptedException {
        System.out.println("Something went wrong. \nNumber of version is " + atm.getCurrentSoftwareVersion() +
                " but it seems like it doesn't fit :-( \nThe recovery process has started... Wait please");
        atm.setCurrentSoftwareVersion(ATM.getPreviousSoftwareVersion());
        Thread.sleep(4000);
        System.out.println("The previous version number " + ATM.getPreviousSoftwareVersion() + " was installed");
    }

    public static class SoftwareUpdateException extends Exception {
        public SoftwareUpdateException(String message) {
            super(message);
        }
    }
}
