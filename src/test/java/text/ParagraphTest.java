package text;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Отдельный класс для тестирования конструкторов и вызовов методов класса {@link Paragraph}.
 */
public class ParagraphTest {
    /**
     * Тестирование конструкторов.
     */
    @Test
    public void testParagraph() {
        assertEquals("", Paragraph.EMPTY_PARAGRAPH);  // проверяем, что константа для пустого абзаца действительно пустая.

        Paragraph paragraph = new Paragraph();  // создание нового абзаца с параметрами по умолчанию (с пустым текстом и нулевым отступом).
        assertEquals(Paragraph.EMPTY_PARAGRAPH, paragraph.getParagraphText());  // проверяем, что по умолчанию создался пустой абзац.
        assertEquals(0, paragraph.getIndent());  // проверяем, что по умолчанию у абзаца нулевой отступ красной строки.

        paragraph = new Paragraph(4);  // создание нового абзаца с отступом красной строки = 4.
        assertEquals(Paragraph.EMPTY_PARAGRAPH, paragraph.getParagraphText());  // проверяем, что по умолчанию создался пустой абзац.
        assertEquals(4, paragraph.getIndent());  // проверяем, что у созданного абзаца действительно отступ красной строки = 4.

        String text = "Как много нам открытий чудных готовит просвещенья дух.";  // строка для примера.
        paragraph = new Paragraph(4, text);  // создание нового абзаца с отступом красной строки = 4.
        assertEquals(4, paragraph.getIndent());  // проверяем, что у созданного абзаца действительно отступ красной строки = 4.
        assertEquals(text, paragraph.getParagraphText());  // проверяем, что у созданного абзаца действительно заданный текст.
    }

    /**
     * Тесторование методов изменения значений переменных класса {@link Paragraph}.
     */
    @Test
    public void testSet() {
        Paragraph paragraph = new Paragraph();  // создаем новый абзац.
        String pangram = "Широкая электрификация южных губерний даст мощный толчок подъёму сельского хозяйства.";  // строка для примера, панграмма - предложение, которое содержит все буквы алфавита.
        paragraph.setParagraphText(pangram);  // задание текста (вышеуказанное предложение) для абзаца.
        paragraph.setIndent(2);  // задаем отступ красной строки = 2.
        assertEquals(pangram, paragraph.getParagraphText());  // проверяем, что у созданного абзаца действительно заданный текст (вышеуказанное предложение).
        assertEquals(2, paragraph.getIndent());  // проверяем, что у созданного абзаца действительно отступ красной строки = 2.
    }
}
