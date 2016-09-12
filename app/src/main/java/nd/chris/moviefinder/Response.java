package nd.chris.moviefinder;

import java.util.List;

/**
 * Created by Chris on 11/11/2015.
 * Last modified by Kevin on 11/17/2015
 */
public class Response {


    /**
     * tmsId : MV006672600000
     * rootId : 11268880
     * subType : Feature Film
     * title : Spectre
     * releaseYear : 2015
     * releaseDate : 2015-10-23
     * titleLang : en
     * descriptionLang : en
     * entityType : Movie
     * genres : ["Action","Adventure","Thriller"]
     * longDescription : A cryptic message from the past leads James Bond (Daniel Craig) to Mexico City and Rome, where he meets the beautiful widow (Monica Bellucci) of an infamous criminal. After infiltrating a secret meeting, 007 uncovers the existence of the sinister organization SPECTRE. Needing the help of the daughter of an old nemesis, he embarks on a mission to find her. As Bond ventures toward the heart of SPECTRE, he discovers a chilling connection between himself and the enemy (Christoph Waltz) he seeks.
     * shortDescription : James Bond (Daniel Craig) discovers a chilling connection between himself and the enemy he seeks.
     * topCast : ["Daniel Craig","Christoph Waltz","Léa Seydoux"]
     * directors : ["Sam Mendes"]
     * officialUrl : http://www.sonypictures.com/movies/spectre/
     * qualityRating : {"ratingsBody":"TMS","value":"3"}
     * ratings : [{"body":"Motion Picture Association of America","code":"PG-13"}]
     * advisories : ["Adult Language","Adult Situations","Violence"]
     * runTime : PT02H28M
     * preferredImage : {"width":"240","height":"360","caption":{"content":"Spectre (2015)","lang":"en"},"uri":"assets/p11268880_p_v5_ab.jpg","category":"Poster Art","text":"yes","primary":"true"}
     * showtimes : [{"theatre":{"id":"9489","name":"Alamo Drafthouse at the Ritz"},"dateTime":"2015-11-11T14:35","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AAUQP&m=145688&d=2015-11-11"},{"theatre":{"id":"9489","name":"Alamo Drafthouse at the Ritz"},"dateTime":"2015-11-11T15:35","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AAUQP&m=145688&d=2015-11-11"},{"theatre":{"id":"9489","name":"Alamo Drafthouse at the Ritz"},"dateTime":"2015-11-11T18:30","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AAUQP&m=145688&d=2015-11-11"},{"theatre":{"id":"9489","name":"Alamo Drafthouse at the Ritz"},"dateTime":"2015-11-11T21:35","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AAUQP&m=145688&d=2015-11-11"},{"theatre":{"id":"5084","name":"Alamo Drafthouse South Lamar"},"dateTime":"2015-11-11T11:25","quals":"Star & Strollers Screening","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AATHS&m=145688&d=2015-11-11"},{"theatre":{"id":"5084","name":"Alamo Drafthouse South Lamar"},"dateTime":"2015-11-11T12:45","quals":"Star & Strollers Screening","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AATHS&m=145688&d=2015-11-11"},{"theatre":{"id":"5084","name":"Alamo Drafthouse South Lamar"},"dateTime":"2015-11-11T15:00","quals":"Star & Strollers Screening","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AATHS&m=145688&d=2015-11-11"},{"theatre":{"id":"5084","name":"Alamo Drafthouse South Lamar"},"dateTime":"2015-11-11T16:15","quals":"Star & Strollers Screening","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AATHS&m=145688&d=2015-11-11"},{"theatre":{"id":"5084","name":"Alamo Drafthouse South Lamar"},"dateTime":"2015-11-11T18:45","quals":"Star & Strollers Screening","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AATHS&m=145688&d=2015-11-11"},{"theatre":{"id":"5084","name":"Alamo Drafthouse South Lamar"},"dateTime":"2015-11-11T19:45","quals":"Star & Strollers Screening","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AATHS&m=145688&d=2015-11-11"},{"theatre":{"id":"5084","name":"Alamo Drafthouse South Lamar"},"dateTime":"2015-11-11T22:15","quals":"Star & Strollers Screening","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AATHS&m=145688&d=2015-11-11"},{"theatre":{"id":"5084","name":"Alamo Drafthouse South Lamar"},"dateTime":"2015-11-11T23:15","quals":"Star & Strollers Screening","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AATHS&m=145688&d=2015-11-11"},{"theatre":{"id":"8298","name":"Regal Westgate Stadium 11 Theatres"},"dateTime":"2015-11-11T10:00","quals":"Descriptive Video Services|No Passes|Closed Captioned","barg":true,"ticketURI":"http://www.fandango.com/tms.asp?t=AANOT&m=145688&d=2015-11-11"},{"theatre":{"id":"8298","name":"Regal Westgate Stadium 11 Theatres"},"dateTime":"2015-11-11T11:15","quals":"Descriptive Video Services|No Passes|Closed Captioned","barg":true,"ticketURI":"http://www.fandango.com/tms.asp?t=AANOT&m=145688&d=2015-11-11"},{"theatre":{"id":"8298","name":"Regal Westgate Stadium 11 Theatres"},"dateTime":"2015-11-11T12:15","quals":"Descriptive Video Services|No Passes|Closed Captioned","barg":true,"ticketURI":"http://www.fandango.com/tms.asp?t=AANOT&m=145688&d=2015-11-11"},{"theatre":{"id":"8298","name":"Regal Westgate Stadium 11 Theatres"},"dateTime":"2015-11-11T13:20","quals":"Descriptive Video Services|No Passes|Closed Captioned","barg":true,"ticketURI":"http://www.fandango.com/tms.asp?t=AANOT&m=145688&d=2015-11-11"},{"theatre":{"id":"8298","name":"Regal Westgate Stadium 11 Theatres"},"dateTime":"2015-11-11T15:30","quals":"Descriptive Video Services|No Passes|Closed Captioned","barg":true,"ticketURI":"http://www.fandango.com/tms.asp?t=AANOT&m=145688&d=2015-11-11"},{"theatre":{"id":"8298","name":"Regal Westgate Stadium 11 Theatres"},"dateTime":"2015-11-11T16:30","quals":"Descriptive Video Services|No Passes|Closed Captioned","barg":true,"ticketURI":"http://www.fandango.com/tms.asp?t=AANOT&m=145688&d=2015-11-11"},{"theatre":{"id":"8298","name":"Regal Westgate Stadium 11 Theatres"},"dateTime":"2015-11-11T18:30","quals":"Descriptive Video Services|No Passes|Closed Captioned","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AANOT&m=145688&d=2015-11-11"},{"theatre":{"id":"8298","name":"Regal Westgate Stadium 11 Theatres"},"dateTime":"2015-11-11T19:00","quals":"Descriptive Video Services|No Passes|Closed Captioned","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AANOT&m=145688&d=2015-11-11"},{"theatre":{"id":"8298","name":"Regal Westgate Stadium 11 Theatres"},"dateTime":"2015-11-11T21:45","quals":"Descriptive Video Services|No Passes|Closed Captioned","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AANOT&m=145688&d=2015-11-11"},{"theatre":{"id":"8298","name":"Regal Westgate Stadium 11 Theatres"},"dateTime":"2015-11-11T22:15","quals":"Descriptive Video Services|No Passes|Closed Captioned","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AANOT&m=145688&d=2015-11-11"},{"theatre":{"id":"5320","name":"AMC Barton Creek Square 14"},"dateTime":"2015-11-11T10:15","quals":"Descriptive Video Services|Closed Captioned","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AANCC&m=145688&d=2015-11-11"},{"theatre":{"id":"5320","name":"AMC Barton Creek Square 14"},"dateTime":"2015-11-11T12:40","quals":"Special Engagement|Descriptive Video Services|Closed Captioned","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AANCC&m=145688&d=2015-11-11"},{"theatre":{"id":"5320","name":"AMC Barton Creek Square 14"},"dateTime":"2015-11-11T13:35","quals":"Descriptive Video Services|Closed Captioned","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AANCC&m=145688&d=2015-11-11"},{"theatre":{"id":"5320","name":"AMC Barton Creek Square 14"},"dateTime":"2015-11-11T16:05","quals":"Special Engagement|Descriptive Video Services|Closed Captioned","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AANCC&m=145688&d=2015-11-11"},{"theatre":{"id":"5320","name":"AMC Barton Creek Square 14"},"dateTime":"2015-11-11T17:00","quals":"Descriptive Video Services|Closed Captioned","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AANCC&m=145688&d=2015-11-11"},{"theatre":{"id":"5320","name":"AMC Barton Creek Square 14"},"dateTime":"2015-11-11T19:15","quals":"Special Engagement|Descriptive Video Services|Closed Captioned","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AANCC&m=145688&d=2015-11-11"},{"theatre":{"id":"5320","name":"AMC Barton Creek Square 14"},"dateTime":"2015-11-11T20:25","quals":"Descriptive Video Services|Closed Captioned","barg":false,"ticketURI":"http://www.fandango.com/tms.asp?t=AANCC&m=145688&d=2015-11-11"},{"theatre":{"id":"8749","name":"Galaxy Highland 10"},"dateTime":"2015-11-11T12:00","barg":false},{"theatre":{"id":"8749","name":"Galaxy Highland 10"},"dateTime":"2015-11-11T12:15","barg":false},{"theatre":{"id":"8749","name":"Galaxy Highland 10"},"dateTime":"2015-11-11T12:30","barg":false},{"theatre":{"id":"8749","name":"Galaxy Highland 10"},"dateTime":"2015-11-11T15:30","barg":false},{"theatre":{"id":"8749","name":"Galaxy Highland 10"},"dateTime":"2015-11-11T15:45","barg":false},{"theatre":{"id":"8749","name":"Galaxy Highland 10"},"dateTime":"2015-11-11T16:00","barg":false},{"theatre":{"id":"8749","name":"Galaxy Highland 10"},"dateTime":"2015-11-11T19:00","barg":false},{"theatre":{"id":"8749","name":"Galaxy Highland 10"},"dateTime":"2015-11-11T19:15","barg":false},{"theatre":{"id":"8749","name":"Galaxy Highland 10"},"dateTime":"2015-11-11T19:30","barg":false},{"theatre":{"id":"8749","name":"Galaxy Highland 10"},"dateTime":"2015-11-11T22:15","barg":false},{"theatre":{"id":"8749","name":"Galaxy Highland 10"},"dateTime":"2015-11-11T22:30","barg":false}]
     */

    private List<MoviesType> movies;

    public void setMovies(List<MoviesType> movies) {
        this.movies = movies;
    }

    public List<MoviesType> getMovies() {
        return movies;
    }

    public static class MoviesType {
        public String getTmsId() {
            return tmsId;
        }

        public void setTmsId(String tmsId) {
            this.tmsId = tmsId;
        }

        public String getRootId() {
            return rootId;
        }

        public void setRootId(String rootId) {
            this.rootId = rootId;
        }

        public String getSubType() {
            return subType;
        }

        public void setSubType(String subType) {
            this.subType = subType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        public void setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getTitleLang() {
            return titleLang;
        }

        public void setTitleLang(String titleLang) {
            this.titleLang = titleLang;
        }

        public String getDescriptionLang() {
            return descriptionLang;
        }

        public void setDescriptionLang(String descriptionLang) {
            this.descriptionLang = descriptionLang;
        }

        public String getEntityType() {
            return entityType;
        }

        public void setEntityType(String entityType) {
            this.entityType = entityType;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public String getLongDescription() {
            return longDescription;
        }

        public void setLongDescription(String longDescription) {
            this.longDescription = longDescription;
        }

        public String getShortDescription() {
            return shortDescription;
        }

        public void setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
        }

        public List<String> getTopCast() {
            return topCast;
        }

        public void setTopCast(List<String> topCast) {
            this.topCast = topCast;
        }

        public List<String> getDirectors() {
            return directors;
        }

        public void setDirectors(List<String> directors) {
            this.directors = directors;
        }

        public String getOfficialUrl() {
            return officialUrl;
        }

        public void setOfficialUrl(String officialUrl) {
            this.officialUrl = officialUrl;
        }

        public QualityType getQualityRating() {
            return qualityRating;
        }

        public void setQualityRating(QualityType qualityRating) {
            this.qualityRating = qualityRating;
        }

        public List<RatingsType> getRatings() {
            return ratings;
        }

        public void setRatings(List<RatingsType> ratings) {
            this.ratings = ratings;
        }

        public List<String> getAdvisories() {
            return advisories;
        }

        public void setAdvisories(List<String> advisories) {
            this.advisories = advisories;
        }

        public String getRunTime() {
            return runTime;
        }

        public void setRunTime(String runTime) {
            this.runTime = runTime;
        }

        public ImageType getPreferredImage() {
            return preferredImage;
        }

        public void setPreferredImage(ImageType preferredImage) {
            this.preferredImage = preferredImage;
        }

        public List<ShowtimeType> getShowtimes() {
            return showtimes;
        }

        public void setShowtimes(List<ShowtimeType> showtimes) {
            this.showtimes = showtimes;
        }

        private String tmsId;
        private String rootId;
        private String subType;
        private String title;
        private int releaseYear;
        private String releaseDate;
        private String titleLang;
        private String descriptionLang;
        private String entityType;
        private List<String> genres;
        private String longDescription;
        private String shortDescription;
        private List<String> topCast;
        private List<String> directors;
        private String officialUrl;
        private QualityType qualityRating;
        private List<RatingsType> ratings;
        private List<String> advisories;
        private String runTime;
        private ImageType preferredImage;
        private List<ShowtimeType> showtimes;

        public static class QualityType{
            public String getRatingsBody() {
                return ratingsBody;
            }

            public void setRatingsBody(String ratingsBody) {
                this.ratingsBody = ratingsBody;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            private String ratingsBody;
            private String value;
        }

        public static class RatingsType{
            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            private String body;
            private String code;
        }

        public static class ImageType{
            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public CaptionType getCaption() {
                return caption;
            }

            public void setCaption(CaptionType caption) {
                this.caption = caption;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getPrimary() {
                return primary;
            }

            public void setPrimary(String primary) {
                this.primary = primary;
            }

            private String width;
            private String height;
            private CaptionType caption;
            private String uri;
            private String category;
            private String text;
            private String primary;

            public static class CaptionType{
                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getLang() {
                    return lang;
                }

                public void setLang(String lang) {
                    this.lang = lang;
                }

                private String content;
                private String lang;
            }
        }

        public static class ShowtimeType{
            public TheatreType getTheatre() {
                return theatre;
            }

            public void setTheatre(TheatreType theatre) {
                this.theatre = theatre;
            }

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }

            public String getQuals() {
                return quals;
            }

            public void setQuals(String quals) {
                this.quals = quals;
            }

            public boolean isBarg() {
                return barg;
            }

            public void setBarg(boolean barg) {
                this.barg = barg;
            }

            public String getTicketURI() {
                return ticketURI;
            }

            public void setTicketURI(String ticketURI) {
                this.ticketURI = ticketURI;
            }

            private TheatreType theatre;
            private String dateTime;
            private String quals;
            private boolean barg;
            private String ticketURI;

            public static class TheatreType{
                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                private String id;
                private String name;
            }
        }
    }
}
