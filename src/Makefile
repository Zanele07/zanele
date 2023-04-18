

JAVAC=/usr/bin/javac
        .SUFFIXES: .java .class
SRCDIR=src
        BINDIR=bin

        $(BINDIR)/%.class:$(SRCDIR)/%.java
        $(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

        CLASSES=BinaryTreeNode.class BinaryTree.class BinaryTreeTest.class BTQueueNode.class BTQueue.class TikTok.class User.class Post.class
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)
        clean:
        rm $(BINDIR)/*.class