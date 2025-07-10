package org.macver.linty.data.types.ui.frame;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.macver.linty.data.types.ui.UIColor;
import org.macver.linty.data.types.ui.UIElement;
import org.macver.linty.data.types.ui.interactive.Button;
import org.macver.linty.data.types.ui.interactive.InteractiveType;
import org.macver.linty.data.types.ui.interactive.Tab;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class TabbedFrame implements Frame {

    @Nullable private final String id;
    @Nonnull private List<Tab> tabs = new ArrayList<>();
    int activeTab = 0;
    @Nonnull private List<Button> buttons = new ArrayList<>();
    @Nullable private String title = null;

    public TabbedFrame(@Nullable String title, Tab... tab) {
        this.id = null;
        contruct(title, tab);
    }

    public TabbedFrame(@Nullable String id, @Nullable String title, Tab... tab) {
        this.id = id;
        contruct(title, tab);
    }

    private void contruct(@Nullable String title, Tab[] tab) {
        this.title = title;
        if (tab == null || tab.length == 0) return;
        tabs.addAll(List.of(tab));
    }

    public void setTabs(@Nonnull List<Tab> tabs) {
        this.tabs = tabs;
    }

    public void setActiveTabNumber(int activeTab) {
        this.activeTab = activeTab;
    }

    public int getActiveTabNumber() {
        return activeTab;
    }

    public Tab getActiveTab() {
        return tabs.get(activeTab);
    }

    @Nonnull
    @Override
    public List<Button> getButtons() {
        return buttons;
    }

    @Nullable
    @Override
    public String getTitle() {
        return title;
    }

    @Nonnull
    public List<Tab> getTabs() {
        return tabs;
    }

    public TabbedFrame setActiveTab(int activeTab) {
        this.activeTab = activeTab;
        return this;
    }

    public TabbedFrame setButtons(@Nonnull List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    public TabbedFrame setTitle(@Nullable String title) {
        this.title = title;
        return this;
    }

    @Override
    public BaseComponent render(int frameCount) {
        // Initialize component builder
        ComponentBuilder builder = new ComponentBuilder();
        String outerFrameEdge = Frame.getFrameEdgeString(frameCount);
        String innerFrameEdge = Frame.getFrameEdgeString(frameCount + 1);
        // Create title bar
        builder.append(outerFrameEdge).color(UIColor.EMPHASIS.color).append("┌").color(UIColor.BORDERS.color).append(this.getTitle()).color(UIColor.EMPHASIS.color).bold(true).append("───\n").bold(false).color(UIColor.BORDERS.color);

        // Add side connector
        builder.append(outerFrameEdge).color(UIColor.EMPHASIS.color).append("├").color(UIColor.BORDERS.color);

        // For each tab, render the tab button
        List<Tab> rootTabs = this.getTabs();
        for (Tab rootTab : rootTabs) {
            if (rootTab == this.getActiveTab()) {
                rootTab.setType(InteractiveType.ACTIVE);
            }
            builder.append(rootTab.renderAlone())
                    .append("─").color(UIColor.BORDERS.color);
        }
        builder.append("──\n").color(UIColor.BORDERS.color);

        // Elements are defined in the tab
        List<UIElement> elements = this.getActiveTab().getContents();

        frameCount++;

        // Append to component builder
        builder.append(innerFrameEdge).color(UIColor.BORDERS.color).append("\n");
        for (UIElement element : elements) {
            builder.append(element.render(frameCount)).append("\n").reset();
        }

        // Create bottom bar
        builder.append(bottomBar(frameCount));

        return builder.build();

    }

    @Nullable
    @Override
    public String id() {
        return this.id;
    }
}
