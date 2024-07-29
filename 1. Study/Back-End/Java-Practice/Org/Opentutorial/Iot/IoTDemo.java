package Org.Opentutorial.Iot;

import java.awt.Color;

public class IoTDemo {
    public static void main(String[] args) {
        // 각 장치의 인스턴스 생성
        Aircon aircon = new Aircon("LivingRoom");
        Lighting lighting = new Lighting("Bedroom");
        ColorDimmingLights colorLights = new ColorDimmingLights("DiningRoom");
        Elevator elevator = new Elevator("MainElevator");
        Refrigerator fridge = new Refrigerator("Kitchen");
        Security security = new Security("MainEntrance");
        Speaker speaker = new Speaker("LivingRoom");

        // 각 장치의 기능 테스트
        aircon.on(24.5);
        aircon.off();

        lighting.on();
        lighting.off();

        colorLights.on();
        colorLights.setBright(75.0);
        colorLights.setColor(Color.BLUE);
        colorLights.off();

        elevator.callForUp(3);
        elevator.callForDown(5);

        fridge.on();
        System.out.println("Milk count: " + fridge.getItemNumber("Milk"));
        fridge.off();

        security.on();
        System.out.println("People in the building: " + security.getExistPeopleNumber());
        security.off();

        speaker.makeVoice("Hello, welcome home!");
    }
}