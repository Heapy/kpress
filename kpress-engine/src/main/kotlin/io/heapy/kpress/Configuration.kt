package io.heapy.kpress

/*
archetypedir = "archetypes"
baseurl = "https://ruslan.ibragimov.by/"
blackfriday = &{Smartypants:true SmartypantsQuotesNBSP:false AngledQuotes:false Fractions:true HrefTargetBlank:false SmartDashes:true LatexDashes:true TaskLists:true PlainIDAnchors:true Extensions:[] ExtensionsMask:[]}
builddrafts = false
buildexpired = false
buildfuture = false
cachedir = "/tmp/hugo_cache/"
canonifyurls = false
cleandestinationdir = false
contentdir = "content"
datadir = "data"
debug = false
defaultcontentlanguage = "en"
defaultcontentlanguageinsubdir = false
defaultlayout = "post"
disablealiases = false
disablefastrender = false
disablelivereload = false
disablepathtolower = false
disqusshortname = "ibragimov-ruslan"
enableemoji = false
enablegitinfo = false
enablemissingtranslationplaceholders = false
footnoteanchorprefix = ""
footnotereturnlinkcontents = ""
forcesyncstatic = false
hascjklanguage = false
i18ndir = "i18n"
ignorecache = false
ignorefiles = []
indexes = map[tag:tags category:categories]
languagecode = "en-us"
languagessorted = [en]
layoutdir = "layouts"
logi18nwarnings = false
metadataformat = "toml"
multilingual = false
newcontenteditor = ""
outputformats = map[rss:map[basename:feed]]
paginate = 10
paginatepath = "page"
params = map[description:Kotlin, FOSS, Developer's Life.]
permalinks = map[page:/:filename/ post:/:year/:month/:day/:filename/]
pluralizelisttitles = true
preservetaxonomynames = false
publishdir = "public"
pygmentscodefences = false
pygmentscodefencesguesssyntax = false
pygmentsoptions = ""
pygmentsstyle = "monokai"
pygmentsuseclasses = false
pygmentsuseclassic = false
relativeurls = false
removepathaccents = false
resourcedir = "resources"
rsslimit = 20
rssuri = "index.xml"
sectionpagesmenu = ""
sitemap = {ChangeFreq: Priority:-1 Filename:sitemap.xml}
staticdir = "static"
summarylength = 70
taxonomies = map[tag:tags category:categories]
theme = "kiss"
themesdir = "themes"
title = "In a Nutshell."
titlecasestyle = "AP"
uglyurls = false
usemodtimeasfallback = false
verbose = false
watch = false
workingdir = "/home/yoda/Desktop/ibragimov_by"

 */
/*
Available Commands:
  benchmark   Benchmark Hugo by building a site a number of times.
  config      Print the site configuration
  import      wordpress/jekyll/hugo

  new         new site/theme
  server      A high performance webserver

  help        Help about any command
  version     Print the version number of Hugo

Flags:
  -b, --baseURL string             hostname (and path) to the root, e.g. http://spf13.com/
  -D, --buildDrafts                include content marked as draft
  -E, --buildExpired               include expired content
  -F, --buildFuture                include content with publishdate in the future
      --cacheDir string            filesystem path to cache directory. Defaults: $TMPDIR/hugo_cache/
      --cleanDestinationDir        remove files from destination not found in static directories
      --config string              config file (default is path/config.yaml|json|toml)
  -c, --contentDir string          filesystem path to content directory
      --debug                      debug output
  -d, --destination string         filesystem path to write files to
      --disableKinds stringSlice   disable different kind of pages (home, RSS etc.)
      --enableGitInfo              add Git revision, date and author info to the pages
      --forceSyncStatic            copy all files when static is changed.
  -h, --help                       help for hugo
      --i18n-warnings              print missing translations
      --ignoreCache                ignores the cache directory
  -l, --layoutDir string           filesystem path to layout directory
      --log                        enable Logging
      --logFile string             log File path (if set, logging enabled automatically)
      --noChmod                    don't sync permission mode of files
      --noTimes                    don't sync modification time of files
      --pluralizeListTitles        (deprecated) pluralize titles in lists using inflect (default true)
      --preserveTaxonomyNames      (deprecated) preserve taxonomy names as written ("Gérard Depardieu" vs "gerard-depardieu")
      --quiet                      build in quiet mode
      --renderToMemory             render to memory (only useful for benchmark testing)
  -s, --source string              filesystem path to read files relative from
      --stepAnalysis               display memory and timing of different steps of the program
      --templateMetrics            display metrics about template executions
      --templateMetricsHints       calculate some improvement hints when combined with --templateMetrics
  -v, --verbose                    verbose output
      --verboseLog                 verbose logging
  -w, --watch                      watch filesystem for changes and recreate as needed

Additional help topics:
  hugo check     Contains some verification checks
 */

/**
 * Configuration of application.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface Configuration {
    val isServer: Boolean
    val theme: String
}

interface ServerConfiguration {
    val port: Int
    val host: String
    val path: String
}

class DefaultServerConfiguration : ServerConfiguration {
    override val port = 8080
    override val host = "0.0.0.0"
    override val path = "blog"
}

// TODO: Temp development configuration, will be replaced with env/arg based config
class DefaultConfiguration : Configuration {
    override val isServer = false
    override val theme = "Ruslan" // get from theme
}

