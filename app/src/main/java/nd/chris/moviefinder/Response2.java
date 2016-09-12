package nd.chris.moviefinder;

/**
 * Created by Chris on 12/8/2015.
 */
public class Response2 {


    /**
     * theatreId : 7059
     * name : Cinemark Movies 6
     * location : {"geoCode":{"latitude":"41.7186","longitude":"-86.1876"},"address":{"street":"6424 N.Grape Rd","state":"IN","city":"Mishawaka","country":"USA","postalCode":"46545"}}
     */

    private String theatreId;
    private String name;
    /**
     * geoCode : {"latitude":"41.7186","longitude":"-86.1876"}
     * address : {"street":"6424 N.Grape Rd","state":"IN","city":"Mishawaka","country":"USA","postalCode":"46545"}
     */

    private LocationEntity location;

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public String getName() {
        return name;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public static class LocationEntity {
        /**
         * latitude : 41.7186
         * longitude : -86.1876
         */

        private GeoCodeEntity geoCode;
        /**
         * street : 6424 N.Grape Rd
         * state : IN
         * city : Mishawaka
         * country : USA
         * postalCode : 46545
         */

        private AddressEntity address;

        private String telephone;

        public void setTelephone(String telephone){this.telephone = telephone;}

        public void setGeoCode(GeoCodeEntity geoCode) {
            this.geoCode = geoCode;
        }

        public void setAddress(AddressEntity address) {
            this.address = address;
        }

        public String getTelephone() {return telephone;}

        public GeoCodeEntity getGeoCode() {
            return geoCode;
        }

        public AddressEntity getAddress() {
            return address;
        }

        public static class GeoCodeEntity {
            private String latitude;
            private String longitude;

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public String getLongitude() {
                return longitude;
            }
        }

        public static class AddressEntity {
            private String street;
            private String state;
            private String city;
            private String country;
            private String postalCode;

            public void setStreet(String street) {
                this.street = street;
            }

            public void setState(String state) {
                this.state = state;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public void setPostalCode(String postalCode) {
                this.postalCode = postalCode;
            }

            public String getStreet() {
                return street;
            }

            public String getState() {
                return state;
            }

            public String getCity() {
                return city;
            }

            public String getCountry() {
                return country;
            }

            public String getPostalCode() {
                return postalCode;
            }
        }
    }
}