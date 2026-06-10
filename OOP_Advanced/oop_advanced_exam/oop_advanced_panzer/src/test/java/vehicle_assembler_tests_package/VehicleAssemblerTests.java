package vehicle_assembler_tests_package;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.*;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;

public class VehicleAssemblerTests {
    private Assembler assembler;

    @Before
    public void setUp() {
        this.assembler = new VehicleAssembler();
    }

    @Test
    public void getTotalWeight() {
        Part partOne = Mockito.mock(Part.class);
        Part partTwo = Mockito.mock(Part.class);
        Part partThree = Mockito.mock(Part.class);

        Mockito.when(partOne.getWeight()).thenReturn(10.0);
        Mockito.when(partTwo.getWeight()).thenReturn(20.0);
        Mockito.when(partThree.getWeight()).thenReturn(40.0);

        this.assembler.addArsenalPart(partOne);
        this.assembler.addEndurancePart(partTwo);
        this.assembler.addShellPart(partThree);

        Assert.assertEquals(70,this.assembler.getTotalWeight(),0.001);
    }

    @Test
    public void getTotalPrice() {
        Part partOne = Mockito.mock(Part.class);
        Part partTwo = Mockito.mock(Part.class);
        Part partThree = Mockito.mock(Part.class);

        Mockito.when(partOne.getPrice()).thenReturn(new BigDecimal("35"));
        Mockito.when(partTwo.getPrice()).thenReturn(new BigDecimal("40"));
        Mockito.when(partThree.getPrice()).thenReturn(new BigDecimal("20"));

        this.assembler.addArsenalPart(partOne);
        this.assembler.addEndurancePart(partTwo);
        this.assembler.addShellPart(partThree);

        BigDecimal expectedTotalPrice = new BigDecimal("95");
        Assert.assertEquals(expectedTotalPrice,this.assembler.getTotalPrice() );
    }

    @Test
    public void getTotalAttackModification() {
        AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(attackModifyingPart.getAttackModifier()).thenReturn(50);

        this.assembler.addArsenalPart(attackModifyingPart);

        Assert.assertEquals(50L,this.assembler.getTotalAttackModification());

    }

    @Test
    public void getTotalDefenseModification() {
        DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(defenseModifyingPart.getDefenseModifier()).thenReturn(55);

        this.assembler.addShellPart(defenseModifyingPart);
        Assert.assertEquals(55L,this.assembler.getTotalDefenseModification());
    }

    @Test
    public void getTotalHitPointModification() {
        HitPointsModifyingPart hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(hitPointsModifyingPart.getHitPointsModifier()).thenReturn(60);

        this.assembler.addEndurancePart(hitPointsModifyingPart);

        Assert.assertEquals(60L,this.assembler.getTotalHitPointModification());
    }

    @Test
    public void addArsenalPart() {
        Part part = Mockito.mock(Part.class);
        Mockito.when(part.getWeight()).thenReturn(10.20);
        this.assembler.addArsenalPart(part);

        double weight = 10.20;
        Assert.assertEquals(weight,this.assembler.getTotalWeight(),0.001);
    }

    @Test
    public void addShellPart() {
        Part part = Mockito.mock(Part.class);
        Mockito.when(part.getPrice()).thenReturn(new BigDecimal("2.30"));
        this.assembler.addShellPart(part);
        BigDecimal expectedPrice = new BigDecimal("2.30");
        Assert.assertEquals(expectedPrice,this.assembler.getTotalPrice());
    }

    @Test
    public void addEndurancePart() {
        Part part = Mockito.mock(Part.class);
        Mockito.when(part.getPrice()).thenReturn(new BigDecimal("5.50"));
        this.assembler.addEndurancePart(part);
        BigDecimal expectedPrice = new BigDecimal("5.50");
        Assert.assertEquals(expectedPrice,this.assembler.getTotalPrice());
    }

    @Test(expected = NullPointerException.class)
    public void testAddArsenalPartWithNull() {
        assembler.addArsenalPart(null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddShellPartWithNull() {
        assembler.addShellPart(null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddEndurancePartWithNull() {
        assembler.addEndurancePart(null);
    }

}

