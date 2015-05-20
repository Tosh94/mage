
/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.timespiral;

import java.util.UUID;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.MageInt;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.combat.CantBeBlockedByOneEffect;
import mage.abilities.effects.common.continuous.GainAbilityAllEffect;
import mage.cards.CardImpl;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.mageobject.SubtypePredicate;

/**
 *
 * @author LevelX2
 */
public class TwoHeadedSliver extends CardImpl {

    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("Sliver creatures");

    static {
        filter.add(new SubtypePredicate("Sliver"));
    }

    public TwoHeadedSliver(UUID ownerId) {
        super(ownerId, 183, "Two-Headed Sliver", Rarity.COMMON, new CardType[]{CardType.CREATURE}, "{1}{R}");
        this.expansionSetCode = "TSP";
        this.subtype.add("Sliver");

        this.power = new MageInt(1);
        this.toughness = new MageInt(1);

        // All Sliver creatures have "This creature can't be blocked except by two or more creatures."
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new GainAbilityAllEffect(
                new SimpleStaticAbility(Zone.BATTLEFIELD, new CantBeBlockedByOneEffect(2)),
                Duration.WhileOnBattlefield, filter,
                "All Sliver creatures have \"This creature can't be blocked except by two or more creatures.\"")));
    }

    public TwoHeadedSliver(final TwoHeadedSliver card) {
        super(card);
    }

    @Override
    public TwoHeadedSliver copy() {
        return new TwoHeadedSliver(this);
    }
}
