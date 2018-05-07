## CRLF LF Nightmares

The proper way to get LF endings in Windows is to first set core.autocrlf to false:

```
git config --global core.autocrlf false
```

You need to do this if you are using msysgit, because it sets it to true in its system settings.

Now git won’t do any line ending normalization. If you want files you check in to be normalized, do this: **Set text=auto in your .gitattributes for all files:**

```
* text=auto
```

And set core.eol to lf:

```
git config --global core.eol lf
```

Now you can also switch single repos to crlf (in the working directory!) by running

```
git config core.eol crlf
```

After you have done the configuration, you might want git to normalize all the files in the repo. To do this, go to to the root of your repo and run these commands:

```
git rm --cached -rf .
git diff --cached --name-only -z | xargs -n 50 -0 git add -f
```
If you now want git to also normalize the files in your working directory, run these commands:

```
git ls-files -z | xargs -0 rm
git checkout .
```

## Add Git support to module

When imported as Maven project, Git support wont be automatic.

Settings -> Version Control -> Select Unregistered root -> Click + (Upper right)