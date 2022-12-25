public class Fighter {
    String nickName;
    int weight;
    int damage;
    int health;
    int block;

    Fighter(String nickName, int weight, int damage, int health, int block) {
        this.nickName = nickName;
        this.weight = weight;
        this.damage = damage;
        this.health = health;
        this.block = block;
    }

    int round(Fighter foe) {
        System.out.println(foe.nickName + " ==> " + this.nickName);
        if (isBlock()) {
            System.out.println(this.nickName + " BLOCKED THE MOVE! ");
            return this.health;
        } else {
            System.out.println(this.nickName + " FAILED TO BLOCK THE MOVE! ");
            return this.health - foe.damage;
        }
    }

    boolean isBlock() {
        double randomValue = Math.random() * 100;
        return randomValue <= this.block;
    }
}
