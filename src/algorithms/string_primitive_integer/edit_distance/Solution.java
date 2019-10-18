package algorithms.string_primitive_integer.edit_distance;

public class Solution {
    //72 leetcode
   /*
         ""  b  e  n  y  a  m
      "" 0   1  2  3  4  5  6
      e  1   1  1  2  3  4  5
      p  2   2  2
      h
      r
      e
      m
      для примера превратим ben в ep.
      1) мы уже знаем что для превращения ben в e требуется 2 хода
      мы добавим p к ben и получим benp. далее нам надо превратить ben в e . это два хода то тогда 1 + 2 = 3
      2) мы заменяем n в ben на p и получаем bep. то есть be надо превратить в e . замена + be в e = 2 хода
      3) мы удалим n  и получим be. для превращения be  в ep требуется 2 хода
    */
}
