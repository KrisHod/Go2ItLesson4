package com.go2it.Lesson4;

public class ATMService {
    public static void installNewVersion(Software newSoftware, ATM atm) throws InterruptedException, VersionTooOldException {
        System.out.println("Number of version is " + atm.getCurrentSoftwareVersion());
        if (atm.getCurrentSoftwareVersion() < newSoftware.getVersion()) {
            ATM.setPreviousSoftwareVersion(atm.getCurrentSoftwareVersion());
            System.out.println("The update process has started... Wait please");
            Thread.sleep(4000);

//            Setter by convention is not supposed to return anything.
//The problem you have (and your flow proves it) - ATM lives separately from Software.
// It should not be the case since ATM should contain/encapsulate the software.
// Then you would be able to get the software version from ATM: atm.getCurrestSoftware().getVersion()

            System.out.println("Number of new version is " + atm.setCurrentSoftwareVersion(newSoftware.getVersion())
                    + " which was released " + newSoftware.getDate());
        }
        else {
            throw new VersionTooOldException("This version of software is too old");
        }
    }

    public static void recoverSoftware(ATM atm) throws InterruptedException {
        System.out.println("Something went wrong. \nNumber of version is " + atm.getCurrentSoftwareVersion() +
                " but it seems like it doesn't fit :-( \nThe recovery process has started... Wait please");
        atm.setCurrentSoftwareVersion(ATM.getPreviousSoftwareVersion());
        Thread.sleep(4000);
        System.out.println("The previous version number " + ATM.getPreviousSoftwareVersion() + " was installed");
    }

    public static class VersionTooOldException extends Exception {
        public VersionTooOldException(String message) {
            super(message);
        }
    }
}
