public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    void run() {
        if (checkWeight()) {
            int counter = 1;
            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("*********************************\n" +
                        "      ROUND " + counter + " HAS STARTED !!\n" +
                        "*********************************");
                if (isChance()) {
                    this.f1.health = this.f1.round(this.f2);
                    if (isWin()) {
                        break;
                    } else {
                        this.f2.health = this.f2.round(f1);
                        if (isWin()) {
                            break;
                        }
                    }
                    printInfo();
                } else {
                    this.f2.health = this.f2.round(this.f1);
                    if (isWin()) {
                        break;
                    } else {
                        this.f1.health = this.f1.round(this.f2);
                        if (isWin()) {
                            break;
                        }
                    }
                    printInfo();
                }
                counter++;
            }
            printInfo();
        } else {
            System.out.println("The weight categories of the boxers do not match.");
        }
    }

    boolean checkWeight() {
        return (this.f1.weight >= this.minWeight && this.f1.weight <= this.maxWeight) &&
                (this.f2.weight >= this.minWeight && this.f2.weight <= this.maxWeight);
    }

    boolean isChance() {
        double randomValue = Math.random() * 10;
        return (randomValue <= 5);
    }

    void printInfo() {
        System.out.println("------------------------------------");
        System.out.println(this.f1.nickName + " 's remaining health:  " + this.f1.health);
        System.out.println(this.f2.nickName + " 's remaining health:  " + this.f2.health);
        System.out.println("------------------------------------");
    }

    boolean isWin() {
        if (this.f1.health <= 0) {
            this.f1.health = 0;
            System.out.println("The winner is " + this.f2.nickName + " !");
            return true;
        } else if (this.f2.health <= 0) {
            this.f2.health = 0;
            System.out.println("The winner is " + this.f1.nickName + " !");
            return true;
        }
        return false;
    }
}
