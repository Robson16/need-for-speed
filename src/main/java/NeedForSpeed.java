class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int distanceDriven;
    private int battery;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.distanceDriven = 0;
        this.battery = 100;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBatteryDrain() {
        return batteryDrain;
    }

    public void setBatteryDrain(int batteryDrain) {
        this.batteryDrain = batteryDrain;
    }

    public int getDistanceDriven() {
        return distanceDriven;
    }

    public void setDistanceDriven(int distanceDriven) {
        this.distanceDriven = distanceDriven;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public boolean batteryDrained() {
        return this.battery < this.batteryDrain;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public void drive() {
        if (!this.batteryDrained()) {
            this.distanceDriven += this.speed;
            this.battery -= this.batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private int distance;

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        int maxSteps = 100 / car.getBatteryDrain();
        int maxDistance = maxSteps * car.getSpeed();

        return maxDistance >= this.distance;
    }
}
