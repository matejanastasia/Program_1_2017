package ua.edu.uzhnu.biks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by elitebook on 22.03.2017.
 */
public class Test1 {
        @Test
        public void test_SanityTest_JUnitWorks() {
            Assert.assertEquals(2, 1 + 1);
        }
        @Test
        public void test_CreateFractionWith1Parametr_FractionParamOne (){
            Assert.assertEquals ((2+"/"+1), new Fraction(2).toString());
        }@Test
        public void test_CreateFractionWith2Parametr_Fraction(){
            Assert.assertEquals ((5+"/"+8), new Fraction(5,8).toString());
        }
        @Test
        public void test_CreateFractionWithNoParametr_FractionZeroOne (){
            Assert.assertEquals ((0 + "/" + 1), new Fraction().toString());
        }


        @Test
        public void test_CreateFractionWithNegativeDenominator_MinusAppliesToNumerator() {
            Fraction f1 = new Fraction(2, -5);
            Assert.assertEquals(-2, f1.getNumerator());
            Assert.assertEquals(5, f1.getDenominator());

            Fraction f2 = new Fraction(5, -8);
            Assert.assertEquals(-5, f2.getNumerator());
            Assert.assertEquals(8, f2.getDenominator());
        }
        @Test
        public void test_CreateFractionWithNegativeDenominatorAndNumerator_FractionWithPositiveFraction (){
            Fraction f1 = new Fraction(-2, -5);
            Assert.assertEquals(2, f1.getNumerator());
            Assert.assertEquals(5, f1.getDenominator());

            Fraction f2 = new Fraction(-5, -8);
            Assert.assertEquals(5, f2.getNumerator());
            Assert.assertEquals(8, f2.getDenominator());
        }

        @Test
        public void test_isProper_Property (){
            Fraction f1 = new Fraction(12, 8);
            Assert.assertEquals(false, f1.isProper());


            Fraction f2 = new Fraction(5, 8);
            Assert.assertEquals(true, f2.isProper());

        }
        @Test
        public void test_toDouble_Double (){
            Fraction f1 = new Fraction(12, 8);
            Assert.assertEquals(1.5 , f1.toDouble(), 0.0001);




        }


        @Test
        public void test_toString_String (){
            Fraction f1 = new Fraction(12, 8);
            Assert.assertEquals(("12/8" ), f1.toString());


            Fraction f2 = new Fraction(5, 8);
            Assert.assertEquals(("5/8" ), f2.toString());

        }

        @Test
        public void test_Simplify_SimplFraction (){
            Fraction f1 = new Fraction(12,8);
            Assert.assertEquals ((3+"/"+2), f1.simplify().toString());
            Fraction f2 = new Fraction(5,8);
            Assert.assertEquals ((5+"/"+8), f2.simplify().toString());
        }
        @Test
        public void test_FractionAdd_SimplFraction(){
            Fraction f1 = new Fraction(12,8);
            Fraction f2 = new Fraction(5,8);
            Assert.assertEquals ( 17+"/"+8,Fraction.add(f1, f2).toString());
            Fraction f3 = new Fraction(12,8);
            Fraction f4 = new Fraction(-5,8);
            Assert.assertEquals ( 7+"/"+8,Fraction.add(f3, f4).toString());
        }
        @Test
        public void test_FractionSubtract_SimplFraction(){
            Fraction f1 = new Fraction(12,8);
            Fraction f2 = new Fraction(5,8);
            Assert.assertEquals ( 7+"/"+8,Fraction.subtract(f1, f2).toString());
            Fraction f3 = new Fraction(12,8);
            Fraction f4 = new Fraction(-5,8);
            Assert.assertEquals ( 17+"/"+8,Fraction.add(f3, f4).toString());
        }
        @Test
        public void test_FractionMultiply_SimplFraction(){
            Fraction f1 = new Fraction(12,8);
            Fraction f2 = new Fraction(5,8);
            Assert.assertEquals ( 15+"/"+16,Fraction.multiply (f1, f2).toString());
            Fraction f3 = new Fraction(12,8);
            Fraction f4 = new Fraction(-5,8);
            Assert.assertEquals ( -15+"/"+16,Fraction.multiply(f3, f4).toString());
        }
        @Test
        public void test_FractionDivide_SimplFraction(){
            Fraction f1 = new Fraction(12,8);
            Fraction f2 = new Fraction(5,8);
            Assert.assertEquals ( 12+"/"+5,Fraction.divide (f1, f2).toString());
            Fraction f3 = new Fraction(12,8);
            Fraction f4 = new Fraction(-5,8);
            Assert.assertEquals ( -12+"/"+5,Fraction.divide(f3, f4).toString());
        }

}
