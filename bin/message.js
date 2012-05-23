// Generated by CoffeeScript 1.3.3
(function() {
  var _ref,
    __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };

  if ((_ref = this.LSC) == null) {
    this.LSC = {};
  }

  this.LSC.Message = (function() {

    function Message(name, source, target, location, lsc) {
      this.name = name;
      this.source = source;
      this.target = target;
      this.location = location;
      this.lsc = lsc;
      this.remove = __bind(this.remove, this);

      this.toJSON = __bind(this.toJSON, this);

      this.unedit = __bind(this.unedit, this);

      this.edit = __bind(this.edit, this);

      this.drop = __bind(this.drop, this);

      this.move = __bind(this.move, this);

      this.drag = __bind(this.drag, this);

      this.update = __bind(this.update, this);

      this.unselect = __bind(this.unselect, this);

      this.select = __bind(this.select, this);

      this.hoverOut = __bind(this.hoverOut, this);

      this.hoverIn = __bind(this.hoverIn, this);

      this.selected = false;
      this.rect = this.lsc.paper.rect(0, 0, 0, 0, 5);
      this.rect.attr({
        stroke: "none",
        fill: "#999",
        opacity: 0,
        cursor: "pointer"
      });
      this.arrow = this.lsc.paper.path("");
      this.arrow.attr({
        "stroke-width": 2,
        stroke: "black",
        cursor: "pointer"
      });
      this.text = this.lsc.paper.text(0, 0, this.name);
      this.arrow.hover(this.hoverIn, this.hoverOut);
      this.text.hover(this.hoverIn, this.hoverOut);
      this.rect.hover(this.hoverIn, this.hoverOut);
      this.arrow.drag(this.move, this.drag, this.drop);
      this.rect.drag(this.move, this.drag, this.drop);
      this.text.drag(this.move, this.drag, this.drop);
      this.text.mousedown(this.select);
      this.rect.mousedown(this.select);
      this.arrow.mousedown(this.select);
      this.text.dblclick(this.edit);
    }

    Message.prototype.hoverIn = function() {
      if (!this.selected) {
        return this.rect.update({
          opacity: cfg.opacity.hover
        });
      }
    };

    Message.prototype.hoverOut = function() {
      if (!this.selected) {
        return this.rect.update({
          opacity: 0
        });
      }
    };

    Message.prototype.select = function(event) {
      if (event != null) {
        if (typeof event.stopPropagation === "function") {
          event.stopPropagation();
        }
      }
      if (!this.selected) {
        this.lsc.clearSelection();
        this.selected = true;
        return this.rect.update({
          opacity: cfg.opacity.selected
        });
      }
    };

    Message.prototype.unselect = function() {
      this.selected = false;
      return this.rect.update({
        opacity: 0
      });
    };

    Message.prototype.update = function() {
      var ar_h, ar_w, p, tx, width, xs, xt, y;
      y = this.lsc.locationY(this.location);
      xs = this.lsc.numberX(this.source.number);
      xt = this.lsc.numberX(this.target.number);
      ar_w = cfg.arrow.width;
      ar_h = cfg.arrow.height;
      width = Math.abs(xs - xt);
      if (xs < xt) {
        p = "M " + xs + "," + y + " h " + (xt - xs - ar_w) + " l 0," + ar_h + " " + ar_w + ",-" + ar_h + " -" + ar_w + ",-" + ar_h + " 0," + ar_h;
        tx = xs + cfg.instance.width / 2;
      } else if (xs === xt) {
        p = "M " + xs + "," + y + " h " + cfg.instance.padding + " v " + 5 + " h " + (-cfg.instance.padding + ar_w) + " l 0," + ar_h + " -" + ar_w + ",-" + ar_h + " " + ar_w + ",-" + ar_h + " 0," + ar_h;
        tx = xs + 2 * cfg.margin;
        width = cfg.instance.padding;
      } else {
        p = "M " + xs + "," + y + " h -" + (xs - xt - ar_w) + " l 0," + ar_h + " -" + ar_w + ",-" + ar_h + " " + ar_w + ",-" + ar_h + " 0," + ar_h;
        tx = xs - cfg.instance.width / 2;
      }
      this.arrow.update({
        path: p
      });
      this.text.update({
        text: this.name,
        x: tx,
        y: y - cfg.margin
      });
      return this.rect.update({
        x: Math.min(xs, xt) - cfg.margin,
        y: y - (cfg.location.height - cfg.margin) / 2 - 10 / 2,
        width: width + 2 * cfg.margin,
        height: cfg.location.height - cfg.margin
      });
    };

    Message.prototype.drag = function(x, y, event) {};

    Message.prototype.move = function(dx, dy, x, y, event) {
      var dst;
      dst = this.lsc.GetLocation(LSC.pageY2RaphaelY(y));
      if (dst !== this.location) {
        return this.lsc.moveMessage(this, dst);
      }
    };

    Message.prototype.drop = function(event) {};

    Message.prototype.edit = function(event) {
      var x, xs, xt,
        _this = this;
      if (this.editor == null) {
        xs = this.lsc.numberX(this.source.number);
        xt = this.lsc.numberX(this.target.number);
        if (xs < xt) {
          x = xs + cfg.arrow.width;
        }
        if (xs === xt) {
          x = xs - cfg.instance.width / 2 + 3 * cfg.margin;
        }
        if (xs > xt) {
          x = xs - cfg.instance.width + cfg.arrow.width;
        }
        this.editor = $("<input type='text'/>");
        this.editor.css({
          left: x,
          top: this.lsc.locationY(this.location) - cfg.margin - 10,
          width: cfg.instance.width - cfg.arrow.width * 2,
          height: 12
        });
        this.editor.addClass("editor centered");
        this.editor.appendTo("#workspace");
        this.text.attr({
          text: "",
          opacity: 0
        });
        this.editor.mousedown(function(e) {
          return e.stopPropagation();
        });
        return this.editor.val(this.name).focus().select().blur(this.unedit).keypress(function(event) {
          if (event.keyCode === 13) {
            return _this.unedit();
          }
        });
      }
    };

    Message.prototype.unedit = function(event) {
      var val;
      if (this.editor != null) {
        if (this.editor.val() === "") {
          return;
        }
        if (!cfg.regex.namepattern.test(this.editor.val())) {
          return;
        }
        val = this.editor.val().trim().match(cfg.regex.namepattern).join('');
        this.name = val;
        this.text.attr({
          text: this.name,
          opacity: 1
        });
        this.editor.remove();
        return this.editor = null;
      }
    };

    Message.prototype.toJSON = function() {
      return {
        name: this.name,
        location: this.location,
        source: this.source.name,
        target: this.target.name
      };
    };

    Message.prototype.remove = function() {
      this.text.remove();
      this.rect.remove();
      return this.arrow.remove();
    };

    return Message;

  })();

}).call(this);
