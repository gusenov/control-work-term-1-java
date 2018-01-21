package text;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Отдельный класс для тестирования конструкторов и вызовов методов класса {@link Text}.
 */
public class TextTest {
    @Test
    public void testText() {
        assertEquals(80, Text.DEFAULT_MAX_CHAR_COUNT_IN_LINE);  // проверяем, что по умолчанию длина строки = 80.

        Text text = new Text();  // создаем новый текст.
        assertEquals(0, text.getParagraphsCount());  // проверяем, что по умолчанию в тексте отсутствуют абзацы.

        // Создаем массив примерных абзацов для последующего тестирования:
        Paragraph[] paragraphs = new Paragraph[] {
                new Paragraph(4, "О сколько нам открытий чудных"),
                new Paragraph(4, "Готовят просвещенья дух"),
                new Paragraph(4, "И опыт, сын ошибок трудных,"),
                new Paragraph(4, "И гений, парадоксов друг,"),
                new Paragraph(4, "И случай, бог изобретатель...")
        };

        text = new Text(paragraphs);  // создаем новый текст на основе вышеприведенных абзацов.
        assertEquals(5, text.getParagraphsCount());  // проверяем, что число абзацов в тексте соответствует 5.
        assertEquals(5, text.getTotalNumberOfLines());  // проверяем, что число строк в тексте соответствует 5.

        Paragraph separator = new Paragraph(0, "        ***        ");  // создадим новый абзац, который будет служить например, разделителем.
        text.insertParagraph(separator, 4);  // добавим абзац-разделитель.

        // Проверка на то, что метод получения абзаца по индексу правильно работатет:
        for (int paragraphIndex = 0; paragraphIndex < paragraphs.length; paragraphIndex++) {
            assertEquals(paragraphs[paragraphIndex], text.getParagraphByIndex(paragraphIndex));
        }
        assertEquals(separator, text.getParagraphByIndex(5));

        // Замени разделитель, вместо звездочек будут минусы:
        String newSeparatorString = "        ---        ";  // новая строка-разделитель.
        Paragraph newSeparator = new Paragraph(0, newSeparatorString);  // новый абзац-разделитель.
        text.replaceParagraph(newSeparator, 5);  // меняем старый абзац на новый абзац.
        assertEquals(newSeparatorString, text.getParagraphByIndex(5).getParagraphText());  // проверяем, что новым разделителем являются действительно минусы.

        text.removeParagraphByIndex(5);  // удалим абзац-разделитель, чтобы проверить как работает удаление абзацов.
        assertEquals(5, text.getParagraphsCount());  // проверим, что абзацов действительно стало меньше.

        text = new Text(paragraphs, 15);  // создадим новый текст с длиной строки 15 символов.
        assertEquals(10, text.getTotalNumberOfLines());  // теперь проверим, что строк стало 10, потому что каждая из них не помещается на одну строку и переносится на другую.

        assertEquals(paragraphs.length, text.getParagraphs().length);  // проверяем, что в тексте присутствуют действительно все наши абзацы.
    }
}
