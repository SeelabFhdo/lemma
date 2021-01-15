# The dependencies of the Sphinx files for LEMMA's offline documentation (cf.
# file "requirements.txt") currently require Sphinx 2.4.3
FROM sphinxdoc/sphinx:2.4.3

WORKDIR /docs
ADD requirements.txt /docs
RUN pip3 install -r requirements.txt