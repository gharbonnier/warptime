import com.arbonoid.warptime.bo.RangedWeapon;
import com.arbonoid.warptime.bo.Target;
import com.arbonoid.warptime.bo.abilities.EAbility;

public class Main {

    public static void main(String[]args) throws Exception
    {
        RangedWeapon bolter = RangedWeapon.builder().ballisticSkill(3).force(4).armourPenetration(0).attack(2).damage(1).abilities(new EAbility[]{EAbility.SUSTAINED_HITS_2}).build();

        Target target = Target.builder().endurance(8).build();

        System.out.println( "Touche ? "+ bolter.fire(target));

    }

}
