## Github Tutorial and Commands with Explaination

-------------------------------



# Table of Content
1. [Git Basics](#git-basics)
2. [Git Branching](#git-branching)
3. [Git On Server](#git-on-server)
4. [Distributed Git](#distributed-git)
5. [Git Internals](#git-internals)

-------------------------------

-------------------------------

## Git Basics

The 3 main states of Git
1. **Modified**: Something is changed in the file but not committed to the database yet. 
2. **Staged**: Marked the modified files in the current version and is ready to int onto next committed snapshots.
3. **Committed**: Data is safely stored in the database.

Set Users Details:

    git config --global user.name "vinit kantrod"
    git config --global user.email "kantrod.vinit@gmail.com"

_To check the settings:_

    git config --list

_To clone an existing repository_
    
    git clone <repo>

_To initialize a repository_

    git init

_Checking status of the file_

    git status
    git status -s   #shorter view of status


_To track new files_

    git add <fileName>

_To track all the files_
    
    git add .

_To ignore files from being tracked_

    cat .gitignore

_To see what is changed by not yet staged_

    git diff

To see what you have staged that will go into next commit

    git diff --staged
    git diff --cached   #staged and cached are synonyms



-------------------------------

## Git Branching



-------------------------------

## Git on Server


------------------------------

## Distributed Git


------------------------------

## Git Internals