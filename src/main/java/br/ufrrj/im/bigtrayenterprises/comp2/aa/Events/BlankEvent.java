package br.ufrrj.im.bigtrayenterprises.comp2.aa.Events;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Character;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Player;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.BlankChoice;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.Choice;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Items.Item;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Skills.AutoAttack;

import java.util.Collection;

/**
 * Created by filipebraida on 31/05/16.
 */
public class BlankEvent extends Event {
    public BlankEvent(Collection<Choice> choices, String description) {
        super(choices);

        this.description = description;
    }

    // It triggers certain choices
    public BlankEvent(Collection<Choice> choices, String description, boolean booleano, Player player) {
        this(choices, description);

        if(booleano)
            player.setGarilho1(true);
        else
            player.setGarilho2(true);
    }

    // It changes the player's health
    public BlankEvent(Collection<Choice> choices, String description, Character player, int damage) {
        this(choices, description);

        player.changeHealth(-damage);
    }

    // It auto-equips the item discovered in this event and change the player's health
    public BlankEvent(Collection<Choice> choices, String description, Player player, Item item, int damage) {
        this(choices, description);

        player.addItem(item);
        player.equipItem(item);

        player.changeHealth(-damage);
    }

    public BlankEvent(Collection<Choice> choices, String description, Player player, AutoAttack autoAttack) {
        this(choices, description);

        player.addSkill(autoAttack);
    }

    @Override
    public void applyHistory(Character character) {
    }

    @Override
    public String getDescription() {
        return description;
    }

    private String description;
}
