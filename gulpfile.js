'use strict'

var gulp = require('gulp'),
    inject = require('gulp-inject'),
    bowerFiles = require('main-bower-files'),
    expect = require('gulp-expect-file'),
    sass = require('gulp-sass'),
    es = require('event-stream'),
    runSequence = require('run-sequence'),
    flatten = require('gulp-flatten'),
    changed = require('gulp-changed'),
    replace = require('gulp-string-replace');

var config = {
                 app: 'src/main/webapp/',
                 dist: 'target/www/',
                 test: 'src/test/javascript/',
                 scss: 'src/main/webapp/scss/',
                 sassSrc: 'src/main/webapp/scss/*.{scss,sass,css}',
                 sassVendor: 'src/main/webapp/scss/vendor.scss',
                 cssDir: 'src/main/webapp/content/css',
                 bower: 'src/main/webapp/bower_components/'
             };

gulp.task('bower-inject',['sass'],function(){
    var index = gulp.src(config.app + 'index.html');
    var stream = index
    .pipe(replace('src/main/webapp/', ''))
    .pipe(inject(gulp.src(bowerFiles(),{read: false}), {name: 'bower'}))
        .pipe(gulp.dest(config.app));
    return es.merge(stream, gulp.src(config.sassVendor)
        .pipe(inject(gulp.src(bowerFiles({filter:['**/*.{scss,sass,css}']}), {read: false}),{
            name: 'bower',
            relative: true
        }))
        .pipe(flatten())
        .pipe(gulp.dest(config.scss)));

});

gulp.task('inject-own', function(){
    gulp.src(config.app + 'index.html')
        .pipe(replace('src/main/webapp/', ''))
        .pipe(inject(gulp.src(config.app + 'app/*.js')))
        .pipe(gulp.dest(config.app));
});

gulp.task('sass', function(){
    return gulp.src(config.sassSrc)
        .pipe(sass())
        .pipe(replace('src/main/webapp/', ''))
        .pipe(changed(config.cssDir, {extension: '.css'}))
        .pipe(flatten())
        .pipe(gulp.dest(config.cssDir));
});

gulp.task('inject-css', function(){
     return gulp.src(config.app + 'index.html')
        .pipe(inject(gulp.src(config.cssDir + '**/*.css')))
        .pipe(flatten())
        .pipe(replace('src/main/webapp/', ''))
        .pipe(gulp.dest(config.app));
});

gulp.task('build', function () {
        runSequence('inject-own','sass','bower-inject', 'inject-css');
});
gulp.task('default', ['build']);

