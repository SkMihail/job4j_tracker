package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int countSubjects = 0;
        for (Pupil pup : pupils) {
            for (Subject sub : pup.subjects()) {
                sum += sub.score();
                countSubjects++;
            }
        }
        return sum / countSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> res = new ArrayList<>();
        for (Pupil pup : pupils) {
            int countSubjects = 0;
            double sum = 0;
            for (Subject sub : pup.subjects()) {
                sum += sub.score();
                countSubjects++;
            }
            res.add(new Label(pup.name(), sum / countSubjects));
        }
        return res;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        HashMap<String, Double> subjectMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                subjectMap.put(sub.name(), sub.score() + subjectMap.getOrDefault(sub.name(), 0D));
            }
        }
        List<Label> res = new ArrayList<>();
        for (String key : subjectMap.keySet()) {
            res.add(new Label(key, subjectMap.get(key) / pupils.size()));
        }
        return res;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            label.add(new Label(pupil.name(), sum));
        }
        label.sort(Comparator.naturalOrder());
        return label.get(label.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> res = averageScoreBySubject(pupils);
        res.sort(Comparator.naturalOrder());
        String nameBest = res.get(res.size() - 1).name();
        double bestScore = res.get(res.size() - 1).score() * pupils.size();
        return new Label(nameBest, bestScore);
    }
}
