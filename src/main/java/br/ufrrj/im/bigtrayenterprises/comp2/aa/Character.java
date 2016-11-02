package br.ufrrj.im.bigtrayenterprises.comp2.aa;

import java.util.ArrayList;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Character {

    public Character(Attributes attributes, ArrayList<Item> items) {
        this.attributes = attributes;
        this.tempAttributes = new Attributes(attributes);
        this.items = items;
    }

    public Character(Attributes attributes) {
        this(attributes, new ArrayList<>());
    }

    public void battle(Character enemy) {
        {
            int damage = getAttackPower() - enemy.getDefensePower();

            if (damage <= 0) {
                damage = 1;
            }

            enemy.changeHealth(-damage);
        }

        {
            int damage = enemy.getAttackPower() - getDefensePower();

            if (damage <= 0) {
                damage = 1;
            }

            changeHealth(-damage);
        }
    }

    public int getDefensePower() {
        Attributes thisAttr = getAttributes();

        return thisAttr.agility + thisAttr.armor + Engine.random.nextInt(5) + 1;
    }

    public int getAttackPower() {
        Attributes thisAttr = getAttributes();

        return thisAttr.strength + thisAttr.agility + Engine.random.nextInt(5) + 1;
    }

    public void changeHealth(int delta) {
        tempAttributes.health += delta;
    }

    public boolean isAlive() {
        return tempAttributes.health > 0;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Attributes getAttributes() {
        Attributes tempWithItems = new Attributes(tempAttributes);

        for (Item item : items) {
            tempWithItems.concatenate(item.getAttributes());
        }

        return tempWithItems;
    }

    private Attributes tempAttributes;
    private final Attributes attributes;
    private ArrayList<Item> items;
}
