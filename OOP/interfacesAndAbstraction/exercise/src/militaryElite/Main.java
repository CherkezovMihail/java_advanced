package militaryElite;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<PrivateImpl> privates = new ArrayList<>();

        while (!input.equals("End")) {

            String[] solgersInfo = input.split(" ");

            String solgerType = solgersInfo[0];

            int id = Integer.parseInt(solgersInfo[1]);
            String firstName = solgersInfo[2];
            String lastName = solgersInfo[3];
            double salary = Double.parseDouble(solgersInfo[4]);

            switch (solgerType) {
                case "Private":
                    PrivateImpl privateSolger = new PrivateImpl(id, firstName, lastName, salary);
                    privates.add(privateSolger);
                    System.out.print(privateSolger);
                    break;
                case "LieutenantGeneral":
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);

                    privates.forEach(lieutenantGeneral::addPrivate);
                    System.out.print(lieutenantGeneral);
                    break;
                case "Engineer":
                    Corps corpus = Corps.valueOf(solgersInfo[5].toUpperCase());
                    EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corpus);

                    String[] repairs = Arrays.stream(solgersInfo, 6, solgersInfo.length).toArray(String[]::new);
                    
                    String part = "";
                    int hours = 0;

                    for (int i = 0; i < repairs.length; i+=2) {
                        part = repairs[i];
                        hours = Integer.parseInt(repairs[i+1]);
                        Repair repair = new Repair(part, hours);
                        engineer.addRepair(repair);
                    }

                    System.out.print(engineer);
                    break;
                case "Commando":
                    Corps corps = Corps.valueOf(solgersInfo[5].toUpperCase());
                    CommandoImpl commandos = new CommandoImpl(id, firstName, lastName, salary, corps);

                    String[] missions = Arrays.stream(solgersInfo, 6, solgersInfo.length).toArray(String[]::new);

                    String missionName = "";
                    String status = "";

                    for (int i = 0; i < missions.length; i+=2) {
                        missionName = missions[i];
                        status = missions[i+1];
                        State state = State.valueOf(status.toUpperCase());
                        Mission mission = new Mission(missionName, state);
                        commandos.addMission(mission);
                    }

                    System.out.print(commandos);
                    break;
                case "Spy":
                    String codeNumber = solgersInfo[4];
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    System.out.print(spy);
                    break;
            }
            System.out.println();
            input = scanner.nextLine();
        }
    }

//    private static boolean isDigit (String part) {
//        char[] chars = part.toCharArray();
//
//        for (char aChar : chars) {
//            if (Character.isDigit(aChar)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
