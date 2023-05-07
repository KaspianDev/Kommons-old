package com.github.kaspiandev.kommons.universal.config;

import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.block.implementation.Section;

public abstract class SectionHolder {

    protected final Section section;

    protected SectionHolder(YamlDocument config, String path) {
        this.section = config.getSection(path);
    }

}
