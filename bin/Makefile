JAVAC=/usr/bin/javac
        .SUFFIXES: .java .class
SRCDIR=src
        BINDIR=bin

        $(BINDIR)/%.class:$(SRCDIR)/%.java
        $(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

        CLASSES=TikTok.class User.class Posts.class BinarySearchTree.class BTQueueNode.class BinaryTreeNode
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)
        clean:
        rm $(BINDIR)/*.class