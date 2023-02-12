package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 50),
                new Attachment("image 3", 10)
        );
        Comparator<Attachment> comparator = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.size(), o2.size());
            }
        };

        Comparator<Attachment> comparatorName = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.name().compareTo(o2.name());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        System.out.println();
        attachments.sort(comparatorName);
        System.out.println(attachments);

    }
}