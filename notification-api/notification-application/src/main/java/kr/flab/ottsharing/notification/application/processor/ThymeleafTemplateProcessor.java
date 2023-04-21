package kr.flab.ottsharing.notification.application.processor;

import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.util.Map;

@Component
public class ThymeleafTemplateProcessor {
    private final TemplateEngine templateEngine;

    public ThymeleafTemplateProcessor(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String process(String position, Map<String, Object> variables ) {
        Context context = new Context();
        context.setVariables(variables);
        return templateEngine.process(position,context);
    }
}
