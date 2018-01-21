package text;  // Пакет – text.

/**
 * Публичный класс {@link Text} – текст.
 */
public class Text {
    // Статичные публичные константы:

    public static final int DEFAULT_MAX_CHAR_COUNT_IN_LINE = 80;

    // Приватные поля класса:

    /**
     * Класс характеризуется максимальным числом символов в строке.
     */
    private int maxCharCountInLine;

    /**
     * Класс явным образом хранит в себе массив абзацев.
     */
    private Paragraph[] paragraphs;

    /**
     * Конструктор по-умолчанию (длинна массива абзацев = 0, число символов 80).
     */
    public Text() {
        this.paragraphs = new Paragraph[0];
        this.maxCharCountInLine = DEFAULT_MAX_CHAR_COUNT_IN_LINE;  // использование значения по умолчанию.
    }

    /**
     * Конструктор может принимать массив абзацев (число символов в строке = 80).
     */
    public Text(Paragraph[] paragraphs) {
        this.paragraphs = paragraphs;
        this.maxCharCountInLine = DEFAULT_MAX_CHAR_COUNT_IN_LINE;  // использование значения по умолчанию.
    }

    /**
     * Конструктор может принимать массив абзацев и число символов в строке.
     * @param paragraphs массив абзацев.
     * @param maxCharCountInLine число символов в строке.
     */
    public Text(Paragraph[] paragraphs, int maxCharCountInLine) {
        this.paragraphs = paragraphs;
        this.maxCharCountInLine = maxCharCountInLine;
    }

    /**
     * Метод, возвращающий общее число абзацев.
     * @return общее число абзацев.
     */
    public int getParagraphsCount() {
        return this.paragraphs.length;
    }

    /**
     * Метод, возвращающий общее число строк текста.
     * @return общее число строк текста.
     */
    public int getTotalNumberOfLines() {
        int totalNumberOfLines = 0;  // переменная для хранения результата.

        for (Paragraph paragraph : this.paragraphs) {  // проходим по всем абзацам:
            int paragraphLength = paragraph.getParagraphText().length();  // получаем длину текста в абзаце.
            totalNumberOfLines += paragraphLength / this.maxCharCountInLine +  // делим длину абзаца на заданное количество символов в строке
                    ((paragraphLength % this.maxCharCountInLine == 0) ? 0 : 1);  // и округляем частное до следующего целого числа.
        }

        return totalNumberOfLines;
    }

    /**
     * Метод, возвращающий ссылку на абзац по его номеру (номер абзаца = номеру в массиве).
     * @return
     */
    public Paragraph getParagraphByIndex(int paragraphIndex) {
        return this.paragraphs[paragraphIndex];
    }

    /**
     * Метод, вставляющий абзац после абзаца (принимает ссылку на новый абзац и номер абзаца, после которого нужно вставить новый).
     * @param newParagraph ссылка на новый абзац.
     * @param paragraphAfterIndex номер абзаца, после которого нужно вставить новый.
     */
    public void insertParagraph(Paragraph newParagraph, int paragraphAfterIndex) {
        Paragraph[] newParagraphs = new Paragraph[this.paragraphs.length + 1];  // создаем новый массив абзацов.

        // Сначала в цикле добавляем в новый массив абзацев все абзацы вплоть до того абзаца после которого надо вставить новый абзац:
        for (int paragraphIndex = 0; paragraphIndex <= paragraphAfterIndex; paragraphIndex++) {
            newParagraphs[paragraphIndex] = this.paragraphs[paragraphIndex];
        }

        newParagraphs[paragraphAfterIndex + 1] = newParagraph;  // добавляем новый абзац.

        // Наконец в цикле добавляем в новый массив абзацев все абзацы, которые шли после того абзаца после которого надо было вставить новый абзац:
        for (int paragraphIndex = paragraphAfterIndex + 1; paragraphIndex < this.paragraphs.length; paragraphIndex++) {
            newParagraphs[paragraphIndex] = this.paragraphs[paragraphIndex];
        }

        this.paragraphs = newParagraphs;  // меняем старый массив абзацов на новый.
    }

    /**
     * Метод удаления абзаца по его номеру.
     * @param paragraphIndexForRemove номер абзаца.
     */
    public void removeParagraphByIndex(int paragraphIndexForRemove) {
        Paragraph[] newParagraphs = new Paragraph[this.paragraphs.length - 1];  // создаем новый массив абзацов.

        // Сначала в цикле добавляем в новый массив абзацев все абзацы ДО удаляемого абзаца:
        for (int paragraphIndex = 0; paragraphIndex < paragraphIndexForRemove; paragraphIndex++) {
            newParagraphs[paragraphIndex] = this.paragraphs[paragraphIndex];
        }

        // Потом в цикле добавляем в новый массив абзацев все абзацы ПОСЛЕ удаляемого абзаца:
        for (int paragraphIndex = paragraphIndexForRemove + 1; paragraphIndex < this.paragraphs.length; paragraphIndex++) {
            newParagraphs[paragraphIndex] = this.paragraphs[paragraphIndex];
        }

        this.paragraphs = newParagraphs;  // меняем старый массив абзацов на новый.
    }

    /**
     * Метод изменения абзаца по его номеру (принимает ссылку на новый абзац и номер абзаца, который нужно заменить новым).
     * @param newParagraph ссылка на новый абзац.
     * @param paragraphIndex номер абзаца, который нужно заменить новым.
     */
    public void replaceParagraph(Paragraph newParagraph, int paragraphIndex) {
        this.paragraphs[paragraphIndex] = newParagraph;  // просто заменяем ссылку на старый абзац, ссылкой на новый абзац.
    }

    /**
     * Метод, возвращающий массив абзацев.
     * @return массив абзацев.
     */
    public Paragraph[] getParagraphs() {
        Paragraph[] arrayOfParagraphs = new Paragraph[this.paragraphs.length];  // создаем результирующий массив абзацов.

        for (int paragraphIndex = 0; paragraphIndex < this.paragraphs.length; paragraphIndex++) {
            // Добавляем в цикле в результирующий массив все абзацы из текста.
            arrayOfParagraphs[paragraphIndex] = this.paragraphs[paragraphIndex];
        }

        return arrayOfParagraphs;  // возвращаем результирующий массив абзацов.
    }
}
