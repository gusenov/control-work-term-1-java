package text;  // Пакет – text.

/**
 * Публичный класс {@link Paragraph} – абзац текстового документа.
 * Класс не хранит явным образом местоположение в тексте, число строк.
 */
public class Paragraph {
    // Статичные публичные константы:

    public static final String EMPTY_PARAGRAPH = "";

    // Приватные поля класса:

    /**
     * Каждый абзац характеризуется строкой, непосредственно содержащей весь текст абзаца.
     */
    private String paragraphText;

    /**
     * Каждый абзац характеризуется отступом красной строки (число символов, а не сантиметры).
     */
    private int indent;

    /**
     * Конструктор по-умолчанию (без параметров) создает «пустой» абзац – характеризующийся пустой строкой, и отступом = 0.
     */
    public Paragraph() {
        this.paragraphText = EMPTY_PARAGRAPH;  // использование значения по умолчанию.
        this.indent = 0;
    }

    /**
     * Конструктор может принимать значение отступа (в этом случае строка – пустая).
     * @param indent значение отступа.
     */
    public Paragraph(int indent) {
        this.indent = indent;
        this.paragraphText = EMPTY_PARAGRAPH;
    }

    /**
     * Конструктор может принимать значение отступа и строку – текст.
     * @param indent значение отступа.
     * @param paragraphText строка – текст.
     */
    public Paragraph(int indent, String paragraphText) {
        this.indent = indent;
        this.paragraphText = paragraphText;
    }

    /**
     * Метод получения строки текста.
     * @return строка текста.
     */
    public String getParagraphText() {
        return paragraphText;
    }

    /**
     * Метод изменения строки текста.
     * @param paragraphText строка текста.
     */
    public void setParagraphText(String paragraphText) {
        this.paragraphText = paragraphText;
    }

    /**
     * Метод получения отступа красной троки.
     * @return отступ красной троки.
     */
    public int getIndent() {
        return indent;
    }

    /**
     * Метод изменения отступа красной троки.
     * @param indent новый отступ красной троки.
     */
    public void setIndent(int indent) {
        this.indent = indent;
    }
}
