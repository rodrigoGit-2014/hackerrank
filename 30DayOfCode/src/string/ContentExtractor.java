package string;

import java.util.Stack;

public class ContentExtractor {

    public static void main(String[] args) {

        String[] sentence = new String[]{
                "<h1>Nayeem loves counseling</h1>",
                "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while<par>",
                "<Amee>safat codes like a ninja</amee>",
                "<SA premium>Imtiaz has a secret crush</SA premium>"
        };
     /*   String[] sentence = new String[]{
                "<h1>some</h1>",
                "<h1>had<h1>public</h1></h1>",
                "<h1>had<h1>public</h1515></h1>",
                "<h1><h1></h1></h1>",
                "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<",
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",
                "<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>",
                "<>hello</>",
                "<>hello</><h>dim</h>",
                "<>hello</><h>dim</h>>>>>"
        };*/

        for (String line : sentence) {
            parse(line);
        }

    }

    public static void parse(String sentence) {

        Tag tag = new Tag();

        while (tag.index < sentence.length()) {

            char current = sentence.charAt(tag.index);

            if (isStartTag(sentence, tag.index)) {
                setStartIndex(sentence, tag);
                tag.openTag = sentence.substring(tag.startIndex, tag.index);
                tag.cleanContent();
            } else if (isCloseTag(sentence, tag.index)) {
                setStartIndex(sentence, tag);
                tag.closeTag = sentence.substring(tag.startIndex + 1, tag.index);
                tag.validateContent();
            } else if (openTagFound(tag)) {
                tag.content += current;
            }

            tag.index++;
        }

        tag.printTags();
    }

    private static void setStartIndex(String sentence, Tag tag) {

        int indexLastOpenTag = tag.index;
        while (tag.index < sentence.length() && !isEndTag(sentence.charAt(tag.index))) {
            tag.index++;
        }
        tag.startIndex = indexLastOpenTag + 1;

    }

    private static boolean openTagFound(Tag tag) {
        return !tag.openTag.isEmpty();
    }

    private static boolean isEndTag(char c) {
        return c == '>';
    }

    private static boolean isStartTag(String s, int currentInd) {
        return s.charAt(currentInd) == '<' && currentInd + 1 < s.length() && s.charAt(currentInd + 1) != '/';
    }

    private static boolean isCloseTag(String s, int currentInd) {
        return s.charAt(currentInd) == '<' && currentInd + 1 < s.length() && s.charAt(currentInd + 1) == '/';
    }

    public static class Tag {
        public String openTag;
        public String closeTag;
        public String content;
        public Integer index;
        public int startIndex;
        public int endIndex;
        public Stack<String> stackOfValidContent;

        public Tag() {
            this.openTag = new String();
            this.closeTag = new String();
            this.content = new String();
            this.index = 0;
            this.startIndex = 0;
            this.endIndex = 0;
            this.stackOfValidContent = new Stack();
        }

        public void validateContent() {
            if (openTag.equals(closeTag) && !content.isEmpty()) {
                stackOfValidContent.push(content);
            }
            clean();
        }

        public void cleanContent() {
            this.content = "";
        }

        private void clean() {
            this.openTag = "";
            this.closeTag = "";
            this.content = "";
        }

        public void printTags() {
            if (stackOfValidContent.isEmpty()) {
                System.out.println("None");
            } else {
                for (String content : stackOfValidContent) {
                    System.out.println(content);
                }
            }
        }
    }
}


