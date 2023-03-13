package com.github.leetcodedaily.minimum_hours_of_training_to_win_a_competition;

/**
 * @Author Dooby Kim
 * @Date 2023/3/13 7:39 下午
 * @Version 1.0
 */
public class Solution {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int experienceAdd = 0;
        int energyAdd = 0;
        int len = energy.length;
        int totalEnergy = 0;
        for (int i = 0; i < len; i++) {
            totalEnergy += energy[i];
        }

        if (totalEnergy + 1 > initialEnergy) {
            energyAdd = totalEnergy + 1 - initialEnergy;
        } else {
            energyAdd = 0;
        }

        int start = initialExperience;
        for (int i = 0; i < len; i++) {
            if (start <= experience[i]) {
                experienceAdd += experience[i] + 1 - start;
                start = 2 * experience[i] + 1;
            } else {
                start += experience[i];
            }
        }

        return energyAdd + experienceAdd;
    }

    public static void main(String[] args) {
        int initialEnergy = 5;
        int initialExperience = 1;
        int[] energy = new int[]{1, 3, 3};
        int[] experience = new int[]{1, 3, 7};
        Solution solution = new Solution();
        System.out.println(solution.minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }
}
